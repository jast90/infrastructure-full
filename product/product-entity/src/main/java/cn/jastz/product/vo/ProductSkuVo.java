package cn.jastz.product.vo;

import cn.jastz.product.entity.Product;
import cn.jastz.product.entity.Sku;

import java.util.List;

/**
 * @author zhiwen
 */
public class ProductSkuVo extends Product {
    private List<Sku> skuList;

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
