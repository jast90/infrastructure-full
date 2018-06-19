package cn.jastz.product.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.product.entity.SkuAttr;
import cn.jastz.product.form.SkuAttrAddForm;
import cn.jastz.product.result.ProductResult;
import cn.jastz.product.service.SkuAttrService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
public class SkuAttrController extends CommonBaseController {

    @Autowired
    private SkuAttrService skuAttrService;

    @GetMapping("sku/attr/list")
    public List<SkuAttr> list() {
        return skuAttrService.queryAll(getAppId());
    }

    @PostMapping("sku/attr")
    public IResult addSkuAttr(@RequestBody SkuAttrAddForm skuAttrAddForm) {
        if (skuAttrService.addSkuAttr(skuAttrAddForm)) {
            return ProductResult.SUCCESS;
        } else {
            return ProductResult.FAIL;
        }
    }
}
