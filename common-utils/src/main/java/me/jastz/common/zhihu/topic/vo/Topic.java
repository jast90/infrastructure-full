package me.jastz.common.zhihu.topic.vo;

/**
 * @author zhiwen
 */
public class Topic {
    private String url;
    private String name;
    private String desc;
    private String img;

    public Topic() {
    }

    public Topic(String url, String name, String desc, String img) {
        this.url = url;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
