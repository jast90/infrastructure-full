package me.jastz.common.haomai.pdd;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public enum  PddJinBaoURLs {

    bao_bei_url("https://jinbao.pinduoduo.com/network/api/common/goodsList","分类url");

    private String url;
    private String desc;

    PddJinBaoURLs(String url, String desc) {
        this.url = url;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
