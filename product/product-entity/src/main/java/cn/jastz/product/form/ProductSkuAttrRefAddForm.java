package cn.jastz.product.form;

import cn.jastz.product.entity.ProductSkuAttrRef;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhiwen
 */
public class ProductSkuAttrRefAddForm {

    private Integer productId;

    private Integer skuAttrId;

    private String skuAttrValue;

    private String appId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        this.skuAttrValue = skuAttrValue;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public ProductSkuAttrRef to() {
        ProductSkuAttrRef productSkuAttrRef = new ProductSkuAttrRef();
        BeanUtils.copyProperties(this, productSkuAttrRef);
        productSkuAttrRef.setCreatedTime(new Date());
        return productSkuAttrRef;
    }
}
