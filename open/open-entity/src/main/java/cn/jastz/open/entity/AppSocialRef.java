package cn.jastz.open.entity;

import java.util.Date;

public class AppSocialRef {
    private String appId;

    private String social;

    private String socialAppId;

    private String socialAppSecret;

    private Date createdTime;

    private Date updatedTime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social == null ? null : social.trim();
    }

    public String getSocialAppId() {
        return socialAppId;
    }

    public void setSocialAppId(String socialAppId) {
        this.socialAppId = socialAppId == null ? null : socialAppId.trim();
    }

    public String getSocialAppSecret() {
        return socialAppSecret;
    }

    public void setSocialAppSecret(String socialAppSecret) {
        this.socialAppSecret = socialAppSecret == null ? null : socialAppSecret.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}