package cn.jastz.mall.vo;

import cn.jastz.product.entity.Product;
import cn.jastz.product.vo.SkuProductVo;
import cn.jastz.store.entity.StoreSkuStock;

/**
 * @author zhiwen
 */
public class StoreSkuProductStockVo extends StoreSkuStock {
    private SkuProductVo skuProductVo;

    public SkuProductVo getSkuProductVo() {
        return skuProductVo;
    }

    public void setSkuProductVo(SkuProductVo skuProductVo) {
        this.skuProductVo = skuProductVo;
    }
}
