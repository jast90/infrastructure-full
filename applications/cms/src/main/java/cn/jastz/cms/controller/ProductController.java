package cn.jastz.cms.controller;

import cn.jastz.product.client.ProductClient;
import cn.jastz.product.form.SkuCategoryAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhiwen
 */
@Controller
public class ProductController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("/product/sku/category")
    public String addSkuCategory() {
        return "product/sku/add";
    }

    @ResponseBody
    @PostMapping("/product/sku/category")
    public BaseResult addSkuCategory(SkuCategoryAddForm skuCategoryAddForm) {
        return productClient.addSkuCategory(skuCategoryAddForm);
    }
}
