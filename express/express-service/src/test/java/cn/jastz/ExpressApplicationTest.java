package cn.jastz;

import cn.jastz.express.ExpressServiceApplication;
import cn.jastz.express.entity.AccountExpress;
import cn.jastz.express.entity.form.AccountExpressAddForm;
import cn.jastz.express.entity.form.AccountExpressQueryLocationForm;
import cn.jastz.express.service.AccountExpressService;
import me.jastz.common.amap.AMapTemplate;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.json.result.SampleResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.json.Json;
import java.util.List;

/**
 * @author zhiwen
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExpressServiceApplication.class)
@ActiveProfiles("ubox")
public class ExpressApplicationTest extends BaseTest {
    @Autowired
    private AccountExpressService accountExpressService;

    AMapTemplate aMapTemplate = new AMapTemplate("aaf82134989a8340917d3c9f5f8f2b4c");

    @Test
    public void test() {
        String fromAddress = "广东省深圳市宝安区灵芝园新村48栋";
        String toAddress = "深圳市南山区深南大道9996号松日鼎盛大厦8层";
        Point point = aMapTemplate.opsForGeo().singleGeoCode(fromAddress);
        System.out.println(JsonUtil.objectToPrettyJson(point));
        AccountExpressAddForm accountExpressForm = new AccountExpressAddForm(point, fromAddress, toAddress, "鞋子一双，2kg", 13);
        Assert.assertTrue(accountExpressService.addAccountExpress(accountExpressForm, getAppId()) == SampleResult.SUCCESS);
    }

    @Test
    public void query() {
        String fromAddress = "深圳市南山区深南大道9996号松日鼎盛大厦8层";
        Point point = aMapTemplate.opsForGeo().singleGeoCode(fromAddress);
        List<AccountExpress> list = accountExpressService.queryByLocation(new AccountExpressQueryLocationForm(point.getY(), point.getX()));
        System.out.println(JsonUtil.objectToPrettyJson(list));
    }

}
