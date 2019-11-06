package cn.jastz.product.service;

import cn.jastz.product.form.SkuCategoryAddForm;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhiwen
 */
public class SkuCategoryServiceTest extends BaseTest {

    @Autowired private SkuCategoryService skuCategoryService;
    @Test
    public void addCategory() {
        SkuCategoryAddForm skuCategoryAddForm = new SkuCategoryAddForm();
        skuCategoryAddForm.setAppId(getAppId());
        skuCategoryAddForm.setCategoryName("mobile");
        skuCategoryAddForm.setCategoryDesc("手机");
        Assert.assertTrue(skuCategoryService.addSkuCategory(skuCategoryAddForm));
    }

}
