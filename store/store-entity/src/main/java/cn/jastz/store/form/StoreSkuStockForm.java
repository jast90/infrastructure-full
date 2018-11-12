package cn.jastz.store.form;

import java.math.BigDecimal;

/**
 * @author zhiwen
 */
public class StoreSkuStockForm {
    private int storeId;
    private int productId;
    private int skuId;
    private BigDecimal skuPrice;
    private BigDecimal skuStock;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
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
}
