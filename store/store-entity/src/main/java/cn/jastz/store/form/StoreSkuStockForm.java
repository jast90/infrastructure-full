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
    /**
     * 扣减库存数
     */
    private Long skuStock;
    /**
     * 库存改变数量：可取正、负数
     */
    private BigDecimal stockChangeQty;

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

    public Long getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Long skuStock) {
        this.skuStock = skuStock;
    }

    public BigDecimal getStockChangeQty() {
        return stockChangeQty;
    }

    public void setStockChangeQty(BigDecimal stockChangeQty) {
        this.stockChangeQty = stockChangeQty;
    }
}
