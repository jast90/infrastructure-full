package me.jastz.common.amap.geo;

import com.google.common.collect.Maps;
import me.jastz.common.amap.entity.AMapURL;
import me.jastz.common.amap.geo.entity.GeoResponse;
import org.springframework.data.geo.Point;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by zhiwen on 2017/6/12.
 */
public class GeoOperationsImpl implements GeoOperations {

    private RestTemplate restTemplate;

    private String key;

    public GeoOperationsImpl(RestTemplate restTemplate, String key) {
        this.restTemplate = restTemplate;
        this.key = key;
    }

    @Override
    public GeoResponse geoCode(String key, String address, String city, boolean batch, String sig) {
        if (key == null) {
            key = this.key;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("key", key);
        params.put("address", address);
        if (city != null) {
            params.put("city", city);
        }
        if (batch) {
            params.put("batch", batch);
        }
        if (sig != null) {
            params.put("sig", sig);
        }
        return restTemplate.getForEntity(AMapURL.GEOCODE.getUrl(), GeoResponse.class, params).getBody();
    }

    @Override
    public Point singleGeoCode(String key, String address) {
        GeoResponse response = geoCode(key, address, null, false, null);
        if (response.getGeocodes() == null || response.getGeocodes().size() == 0) {
            return null;
        }
        return response.getGeocodes().get(0).getLocalPoint();
    }

    @Override
    public Point singleGeoCode(String address) {
        return singleGeoCode(null, address);
    }
}
