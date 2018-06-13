package cn.jastz.product.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.product.form.SkuCategoryAddForm;
import cn.jastz.product.result.ProductResult;
import cn.jastz.product.service.SkuCategoryService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
public class SkuCategoryController extends CommonBaseController {
    @Autowired
    private SkuCategoryService skuCategoryService;

    @PostMapping("sku/category")
    public IResult add(@RequestBody SkuCategoryAddForm addForm) {
        addForm.setAppId(getAppId());
        if (skuCategoryService.addSkuCategory(addForm)) {
            return ProductResult.SUCCESS;
        } else {
            return ProductResult.FAIL;
        }
    }
}
