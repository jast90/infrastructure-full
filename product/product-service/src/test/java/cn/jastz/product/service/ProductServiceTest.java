package cn.jastz.product.service;

import cn.jastz.product.form.ProductAddForm;
import me.jastz.common.json.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhiwen
 */

public class ProductServiceTest extends BaseTest{

    @Autowired
    private ProductService productService;

    @Test
    public void addProduct() {
        ProductAddForm productAddForm = new ProductAddForm();
        productAddForm.setAppId(getAppId());
        productAddForm.setProductName("iPhone X");
        productAddForm.setProductCode("iphone-x");
        productAddForm.setProductDesc("Apple iPhone X");
        Assert.assertTrue(productService.addProduct(productAddForm));
    }

    @Test
    public void queryProductVo() {
        System.out.println(JsonUtil.objectToPrettyJson(productService.queryProductVo(1)));
    }

    @Test
    public void queryAllProductSkuVoList() {
        System.out.println(JsonUtil.objectToPrettyJson(productService.queryAllProductSkuVoList()));
    }

}
