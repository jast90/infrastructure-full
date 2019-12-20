package me.jastz.common.juejin;

/**
 * @author zhangzhiwen on 2019/11/26
 **/
public enum  JueJinURLs {
    xiangqin("https://short-msg-ms.juejin.im/v1/pinList/topic?uid={uid}&device_id={deviceId}&token={token}&src=web&topicId={topicId}&page={page}&pageSize={pageSize}&sortType=rank");
    private String url;

    JueJinURLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
