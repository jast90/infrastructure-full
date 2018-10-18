package cn.jastz.common.entity.enums;

/**
 * @author zhiwen
 */
public enum SocialEnum {
    WECHAT("微信"),
    QQ("QQ"),
    WEIBO("微博"),
    GITHUB("GitHub");

    private String desc;

    SocialEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
