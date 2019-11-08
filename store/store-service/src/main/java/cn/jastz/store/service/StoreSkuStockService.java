package cn.jastz.store.service;

import cn.jastz.store.entity.StoreSkuStock;
import cn.jastz.store.form.StoreSkuStockForm;
import cn.jastz.store.mapper.StoreSkuStockMapper;
import com.google.common.util.concurrent.Striped;
import io.lettuce.core.RedisClient;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhiwen
 */
@Service
public class StoreSkuStockService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StoreSkuStockMapper storeSkuStockMapper;

    private static final Striped<Lock> striped = Striped.lazyWeakLock(127);


    private static Map<String, ReentrantLock> storeSkuStockLock = new ConcurrentHashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    RedisClient client = RedisClient.create("redis://localhost");

    private RedissonClient redisson = Redisson.create();

    private ReentrantLock reentrantLock = new ReentrantLock(true);


    public List<StoreSkuStock> queryStoreSkuStoreByStoreId(int storeId) {
        return storeSkuStockMapper.selectListByStoreId(storeId);
    }


    //    @Transactional
    public IResult reduceStockByStoreIdAndSkuId(int storeId, int productId, int skuId, long skuStock) {
//        loadToRedis(storeId, productId, skuId);
        //TODO 并发行考虑
        String key = String.format("%s:%s:%s", storeId, productId, skuId);
       /* Long value = redisTemplate.opsForValue().decrement(key, skuStock.longValue());
        if (value < 0) {
            throw new IllegalArgumentException();
        }*/

        RLock lock = redisson.getLock(key);
        /*ReentrantLock reentrantLock1 = new ReentrantLock(true);
        ReentrantLock existLock = storeSkuStockLock.putIfAbsent(key,reentrantLock1);
        if(existLock!=null){
            reentrantLock1 = existLock;
        }*/
        try {
//            reentrantLock1.lock();
            lock.lock(3, TimeUnit.SECONDS);
            if (skuStock <= 0) {
                return SampleResult.FAIL;
            }
            StoreSkuStock storeSkuStock = storeSkuStockMapper.selectByPrimaryKey(storeId, productId, skuId);

            //库存当前库存数小于

            //减库存且超出可用库存
            if ((storeSkuStock.getSkuStock()<0)|| storeSkuStock.getSkuStock()<skuStock) {
                //TODO 改成枚举
                return SampleResult.FAIL;
            }
            long stockChangeTo = storeSkuStock.getSkuStock()-skuStock;
            StoreSkuStock changeStock = new StoreSkuStock(productId, storeId, skuId);
            changeStock.setSkuStock(stockChangeTo);
            if (storeSkuStockMapper.updateByPrimaryKey(changeStock) > 0) {
                return SampleResult.SUCCESS;
            }

        } finally {
            lock.unlock();
//            reentrantLock1.unlock();
            log.debug("{}减库存结束", Thread.currentThread().getName());
        }
        return SampleResult.FAIL;
    }

    public IResult updatePriceByStoreIdAndSkuId(int storeId, int productId, int skuId, BigDecimal price) {
        StoreSkuStock storeSkuStock = new StoreSkuStock(productId, storeId, skuId);
        storeSkuStock.setSkuPrice(price);
        if (storeSkuStockMapper.updateByPrimaryKey(storeSkuStock) > 0) {
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }

    public Map<Integer,IResult> orderReduceStocks(List<StoreSkuStockForm> storeSkuStockForms) {
        Map<Integer,IResult> map = new TreeMap<>();
        storeSkuStockForms.forEach(storeSkuStockForm -> {
            IResult result = reduceStockByStoreIdAndSkuId(storeSkuStockForm.getStoreId(),storeSkuStockForm.getProductId(),
                    storeSkuStockForm.getSkuId(),storeSkuStockForm.getSkuStock());
            map.put(storeSkuStockForm.getSkuId(),result);
        });
        return map;
    }
}
