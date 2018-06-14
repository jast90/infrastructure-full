package cn.jastz.product.vo;

import cn.jastz.product.entity.Product;

import java.util.List;

/**
 * @author zhiwen
 */
public class ProductVo extends Product {
    List<ProductSkuAttrRefVo> productSkuAttrRefVos;

    public List<ProductSkuAttrRefVo> getProductSkuAttrRefVos() {
        return productSkuAttrRefVos;
    }

    public void setProductSkuAttrRefVos(List<ProductSkuAttrRefVo> productSkuAttrRefVos) {
        this.productSkuAttrRefVos = productSkuAttrRefVos;
    }
}
