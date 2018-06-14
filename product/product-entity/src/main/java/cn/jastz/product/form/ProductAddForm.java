package cn.jastz.product.form;

import cn.jastz.product.entity.Product;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhiwen
 */
public class ProductAddForm {
    private String appId;
    private String productName;
    private String productCode;
    private String productDesc;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Product to() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        product.setCreatedTime(new Date());
        return product;
    }
}
