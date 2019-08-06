package me.jastz.common.amap.geo.entity;

import me.jastz.common.amap.entity.CountResponse;

import java.util.List;

/**
 * Created by zhiwen on 2017/6/12.
 */
public class GeoResponse extends CountResponse{
    List<GeoCode> geocodes;

    public List<GeoCode> getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(List<GeoCode> geocodes) {
        this.geocodes = geocodes;
    }
}
