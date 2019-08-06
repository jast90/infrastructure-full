package me.jastz.common.amap;

import me.jastz.common.amap.geo.GeoOperations;
import me.jastz.common.amap.geo.GeoOperationsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhiwen on 2017/6/12.
 */
@Component
public class AMapTemplate implements AMapOperations {
    private RestTemplate restTemplate;
    @Value("${amap.key}")
    private String key;

    public AMapTemplate() {
        this(new RestTemplate());
    }

    public AMapTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AMapTemplate(String key) {
        this.key = key;
        this.restTemplate = new RestTemplate();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GeoOperations opsForGeo() {
        if (key == null) {
            throw new RuntimeException("Amap key is null, please set `amap.key` in properties.");
        }
        return new GeoOperationsImpl(this.getRestTemplate(), key);
    }
}
