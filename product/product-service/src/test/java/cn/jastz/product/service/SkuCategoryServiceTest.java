package cn.jastz.product.service;

import cn.jastz.product.BaseTest;
import cn.jastz.product.form.SkuCategoryAddForm;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhiwen
 */
public class SkuCategoryServiceTest extends BaseTest<SkuCategoryService> {

    @Test
    public void addCategory() {
        SkuCategoryAddForm skuCategoryAddForm = new SkuCategoryAddForm();
        skuCategoryAddForm.setAppId(getAppId());
        skuCategoryAddForm.setCategoryName("mobile");
        skuCategoryAddForm.setCategoryDesc("手机");
        Assert.assertTrue(service.addSkuCategory(skuCategoryAddForm));
    }

}
