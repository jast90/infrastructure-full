package cn.jastz.product.vo;

import cn.jastz.product.entity.ProductSkuAttrRef;
import cn.jastz.product.entity.SkuAttr;

/**
 * @author zhiwen
 */
public class ProductSkuAttrRefVo extends ProductSkuAttrRef {
    private SkuAttr skuAttr;

    public SkuAttr getSkuAttr() {
        return skuAttr;
    }

    public void setSkuAttr(SkuAttr skuAttr) {
        this.skuAttr = skuAttr;
    }
}
