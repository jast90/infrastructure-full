package cn.jastz.product.entity;

import java.util.Date;

public class SkuAttrRef {
    private Integer refId;

    private Integer skuId;

    private Integer skuAttrId;

    private String skuAttrValue;

    private String appId;

    private Date createdTime;

    private Date updatedTime;

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public String getSkuAttrValue() {
        return skuAttrValue;
    }

    public void setSkuAttrValue(String skuAttrValue) {
        this.skuAttrValue = skuAttrValue == null ? null : skuAttrValue.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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