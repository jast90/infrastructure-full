package cn.jastz.product.service;

import cn.jastz.product.BaseTest;
import cn.jastz.product.form.ProductAddForm;
import me.jastz.common.json.JsonUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhiwen
 */

public class ProductServiceTest extends BaseTest<ProductService> {


    @Test
    public void addProduct() {
        ProductAddForm productAddForm = new ProductAddForm();
        productAddForm.setAppId(getAppId());
        productAddForm.setProductName("iPhone X");
        productAddForm.setProductCode("iphone-x");
        productAddForm.setProductDesc("Apple iPhone X");
        Assert.assertTrue(service.addProduct(productAddForm));
    }

    @Test
    public void queryProductVo() {
        System.out.println(JsonUtil.objectToPrettyJson(service.queryProductVo(1)));
    }
}
