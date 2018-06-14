package cn.jastz.product.service;

import cn.jastz.product.BaseTest;
import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhiwen
 */
public class SkuServiceTest extends BaseTest<SkuService> {

    @Test
    public void addSku() {
        SkuAddForm skuAddForm = new SkuAddForm();
        skuAddForm.setAppId(getAppId());
        skuAddForm.setPrice(new BigDecimal(8316));
        skuAddForm.setProductId(1);
        skuAddForm.setSkuCode("iphone-x-space_gray-64GB");
        Assert.assertTrue(service.addSku(skuAddForm));
    }

    @Test
    public void batchAddSkuAttrRef() {
        SkuAttrRefBatchAddForm skuAttrRefBatchAddForm = new SkuAttrRefBatchAddForm();
        List<SkuAttrRefAddForm> list = Lists.newArrayList();
        list.add(new SkuAttrRefAddForm(1, 1, "space_gray", getAppId()));
        list.add(new SkuAttrRefAddForm(1, 3, "64G", getAppId()));
        skuAttrRefBatchAddForm.setList(list);
        Assert.assertTrue(service.batchAddSkuAttrRef(skuAttrRefBatchAddForm));
    }
}
