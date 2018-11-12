package cn.jastz.store.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StoreSkuStock {

    private Integer productId;

    private Integer storeId;

    private Integer skuId;

    private BigDecimal skuPrice;

    private BigDecimal skuStock;

    private Date createdTime;

    private Date updateTime;

    public StoreSkuStock() {
    }

    public StoreSkuStock(Integer productId, Integer storeId, Integer skuId) {
        this.productId = productId;
        this.storeId = storeId;
        this.skuId = skuId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public BigDecimal getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(BigDecimal skuStock) {
        this.skuStock = skuStock;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}