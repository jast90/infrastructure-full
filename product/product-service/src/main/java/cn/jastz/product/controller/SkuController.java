package cn.jastz.product.controller;

import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import cn.jastz.product.result.ProductResult;
import cn.jastz.product.service.SkuService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
public class SkuController {
    @Autowired
    private SkuService skuService;

    @PostMapping("sku")
    public IResult addSku(@RequestBody SkuAddForm skuAddForm) {
        if (skuService.addSku(skuAddForm)) {
            return ProductResult.SUCCESS;
        } else {
            return ProductResult.FAIL;
        }
    }

    @PostMapping("sku/attr/ref")
    public IResult batchAddSkuAttrRef(@RequestBody SkuAttrRefBatchAddForm skuAttrRefBatchAddForm) {
        if (skuService.batchAddSkuAttrRef(skuAttrRefBatchAddForm)) {
            return ProductResult.SUCCESS;
        } else {
            return ProductResult.FAIL;
        }
    }

}
