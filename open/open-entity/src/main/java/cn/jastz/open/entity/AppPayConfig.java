package cn.jastz.open.entity;

import java.util.Date;
import java.util.List;

public class AppPayConfig {
    private Long appPayConfigId;

    private String appId;

    private String payPlatform;

    private Date createdTime;

    private Date updatedTime;

    private List<AppPayConfigDetails> appPayConfigDetailsList;

    public Long getAppPayConfigId() {
        return appPayConfigId;
    }

    public void setAppPayConfigId(Long appPayConfigId) {
        this.appPayConfigId = appPayConfigId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform == null ? null : payPlatform.trim();
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

    public List<AppPayConfigDetails> getAppPayConfigDetailsList() {
        return appPayConfigDetailsList;
    }

    public void setAppPayConfigDetailsList(List<AppPayConfigDetails> appPayConfigDetailsList) {
        this.appPayConfigDetailsList = appPayConfigDetailsList;
    }
}