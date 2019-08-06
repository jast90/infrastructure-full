package me.jastz.amap;

import me.jastz.common.amap.AMapTemplate;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhiwen on 2017/6/12.
 */
public class AMapTemplateTest {
    private String key = "aaf82134989a8340917d3c9f5f8f2b4c";
    private AMapTemplate amapTemplate;

    @Before
    public void setUp() {
        amapTemplate = new AMapTemplate(key);
    }


    @Test
    public void geoCode() {
        System.out.println(amapTemplate.opsForGeo().singleGeoCode(key, "深圳市南山区深南大道9996号松日鼎盛大厦8层"));
    }
}
