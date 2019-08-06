package me.jastz.common.amap.entity;

/**
 * Created by zhiwen on 2017/6/12.
 */
public enum AMapURL {
    GEOCODE("http://restapi.amap.com/v3/geocode/geo?key={key}&address={address}")
    ;
    private String url;

    AMapURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
