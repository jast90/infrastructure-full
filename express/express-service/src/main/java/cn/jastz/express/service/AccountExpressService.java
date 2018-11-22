package cn.jastz.express.service;

import cn.jastz.express.RedisConstants;
import cn.jastz.express.entity.AccountExpress;
import cn.jastz.express.entity.form.AccountExpressAddForm;
import cn.jastz.express.entity.form.AccountExpressQueryLocationForm;
import cn.jastz.express.mapper.AccountExpressMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author zhiwen
 */
@Service
public class AccountExpressService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountExpressMapper accountExpressMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional
    public IResult addAccountExpress(AccountExpressAddForm accountExpressForm, String appId) {
        AccountExpress accountExpress = accountExpressForm.to();
        accountExpress.setAppId(appId);
        if (accountExpressMapper.insert(accountExpress) > 0) {
            GeoOperations<String, Integer> geoOperations = redisTemplate.opsForGeo();
            if (geoOperations.geoAdd(RedisConstants.accountExpress, accountExpressForm.getPoint(), accountExpress.getExpressId()) < 0) {
                //添加到redis异常时需要放入延时队列中，确保发布的任务写入到redis geo
                logger.warn("account express add redis geo fail,please process it by yourself.");
            }
            return SampleResult.SUCCESS;
        } else {
            return SampleResult.FAIL;
        }
    }

    public List<AccountExpress> queryByLocation(AccountExpressQueryLocationForm queryLocationForm) {
        //十公里以内发布
        Circle circle = new Circle(queryLocationForm.getPoint(), new Distance(10, Metrics.KILOMETERS));
        GeoResults<RedisGeoCommands.GeoLocation<Integer>> results = redisTemplate.opsForGeo().geoRadius(RedisConstants.accountExpress, circle, RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance());
        Map<Integer, Distance> map = Maps.newHashMap();
        results.forEach(geoLocationGeoResult -> map.put(geoLocationGeoResult.getContent().getName(), geoLocationGeoResult.getDistance()));
        logger.debug("queryByLocation map:{}", JsonUtil.objectToPrettyJson(map));
        if (CollectionUtils.isEmpty(map)) {
            return Lists.newArrayList();
        }
        return accountExpressMapper.selectByExpressIds(Lists.newArrayList(map.keySet()));
    }

}
