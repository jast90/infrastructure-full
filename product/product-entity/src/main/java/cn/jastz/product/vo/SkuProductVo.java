package cn.jastz.product.vo;

import cn.jastz.product.entity.Product;
import cn.jastz.product.entity.Sku;

/**
 * @author zhiwen
 */
public class SkuProductVo extends Sku {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
