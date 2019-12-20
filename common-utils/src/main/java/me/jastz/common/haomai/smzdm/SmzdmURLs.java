package me.jastz.common.haomai.smzdm;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public enum SmzdmURLs {
    category_url("https://www.smzdm.com/","分类url");

    private String url;
    private String desc;

    SmzdmURLs(String url, String desc) {
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
