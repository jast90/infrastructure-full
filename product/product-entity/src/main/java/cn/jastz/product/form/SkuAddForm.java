package cn.jastz.product.form;

import cn.jastz.product.entity.Sku;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhiwen
 */
public class SkuAddForm {
    private int productId;
    private String skuCode;
    private BigDecimal price;
    private String appId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Sku to() {
        Sku sku = new Sku();
        BeanUtils.copyProperties(this, sku);
        sku.setCreatedTime(new Date());
        return sku;
    }
}
