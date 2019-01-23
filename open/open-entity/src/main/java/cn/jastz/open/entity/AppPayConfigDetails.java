package cn.jastz.open.entity;

import java.util.Date;

public class AppPayConfigDetails {
    private Long appPayConfigId;

    private String attrName;

    private Date createdTime;

    private Date updatedTime;

    private String attrValue;

    public Long getAppPayConfigId() {
        return appPayConfigId;
    }

    public void setAppPayConfigId(Long appPayConfigId) {
        this.appPayConfigId = appPayConfigId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
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

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }
}