package me.jastz.common.amap.geo;

import me.jastz.common.amap.geo.entity.GeoResponse;
import org.springframework.data.geo.Point;


/**
 * Created by zhiwen on 2017/6/12.
 */
public interface GeoOperations {

    /**
     * <a href='http://lbs.amap.com/api/webservice/guide/api/georegeo'></a>
     *
     * @param key
     * @param address 规则： 省+市+区+街道+门牌号。如果有多个地址的话，请用"|"进行间隔
     *                ，并且设置batch=true。最多支持10个地址。
     * @param city
     * @param batch
     * @param sig
     * @return
     */
    GeoResponse geoCode(String key, String address, String city, boolean batch, String sig);

    Point singleGeoCode(String key, String address);

    /**
     * x 经度
     * y 纬度
     *
     * @param address
     * @return
     */
    Point singleGeoCode(String address);
}
