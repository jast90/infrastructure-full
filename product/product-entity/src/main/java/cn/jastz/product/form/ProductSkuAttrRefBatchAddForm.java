package cn.jastz.product.form;

import cn.jastz.product.entity.ProductSkuAttrRef;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhiwen
 */
public class ProductSkuAttrRefBatchAddForm {
    private List<ProductSkuAttrRefAddForm> productSkuAttrRefAddFormList;

    public List<ProductSkuAttrRefAddForm> getProductSkuAttrRefAddFormList() {
        return productSkuAttrRefAddFormList;
    }

    public void setProductSkuAttrRefAddFormList(List<ProductSkuAttrRefAddForm> productSkuAttrRefAddFormList) {
        this.productSkuAttrRefAddFormList = productSkuAttrRefAddFormList;
    }

    public List<ProductSkuAttrRef> list() {
        List<ProductSkuAttrRef> productSkuAttrRefs = Lists.newArrayList();
        productSkuAttrRefAddFormList.forEach(productSkuAttrRefAddForm -> productSkuAttrRefs.add(productSkuAttrRefAddForm.to()));
        return productSkuAttrRefs;
    }
}
