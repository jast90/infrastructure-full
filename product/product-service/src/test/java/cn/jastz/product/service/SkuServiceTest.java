package cn.jastz.product.service;

import cn.jastz.product.BaseTest;
import cn.jastz.product.entity.Sku;
import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import cn.jastz.product.vo.SkuProductVo;
import me.jastz.common.json.JsonUtil;
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

        skuAddForm = new SkuAddForm();
        skuAddForm.setAppId(getAppId());
        skuAddForm.setPrice(new BigDecimal(9605));
        skuAddForm.setProductId(1);
        skuAddForm.setSkuCode("iphone-x-space_gray-256GB");
        Assert.assertTrue(service.addSku(skuAddForm));

        skuAddForm = new SkuAddForm();
        skuAddForm.setAppId(getAppId());
        skuAddForm.setPrice(new BigDecimal(8316));
        skuAddForm.setProductId(1);
        skuAddForm.setSkuCode("iphone-x-silver-64GB");
        Assert.assertTrue(service.addSku(skuAddForm));

        skuAddForm = new SkuAddForm();
        skuAddForm.setAppId(getAppId());
        skuAddForm.setPrice(new BigDecimal(9605));
        skuAddForm.setProductId(1);
        skuAddForm.setSkuCode("iphone-x-silver-256GB");
        Assert.assertTrue(service.addSku(skuAddForm));
    }

    @Test
    public void batchAddSkuAttrRef() {
        SkuAttrRefBatchAddForm skuAttrRefBatchAddForm = new SkuAttrRefBatchAddForm();
        List<SkuAttrRefAddForm> list = Lists.newArrayList();
        list.add(new SkuAttrRefAddForm(1, 1, "space_gray", getAppId()));
        list.add(new SkuAttrRefAddForm(1, 3, "64G", getAppId()));
        list.add(new SkuAttrRefAddForm(2, 1, "space_gray", getAppId()));
        list.add(new SkuAttrRefAddForm(2, 3, "256G", getAppId()));
        list.add(new SkuAttrRefAddForm(3, 1, "silver", getAppId()));
        list.add(new SkuAttrRefAddForm(3, 3, "64G", getAppId()));
        list.add(new SkuAttrRefAddForm(4, 1, "silver", getAppId()));
        list.add(new SkuAttrRefAddForm(4, 3, "256G", getAppId()));
        skuAttrRefBatchAddForm.setList(list);
        Assert.assertTrue(service.batchAddSkuAttrRef(skuAttrRefBatchAddForm));
    }

    @Test
    public void test() {
        List<SkuProductVo> list = service.queryListByIds(Lists.newArrayList(1, 2, 3));
        System.out.println(JsonUtil.objectToJson(list));
    }
}
