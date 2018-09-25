package cn.jastz.product.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.product.entity.Sku;
import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import cn.jastz.product.result.ProductResult;
import cn.jastz.product.service.SkuService;
import cn.jastz.product.vo.SkuProductVo;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
public class SkuController extends CommonBaseController {
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

    @PostMapping("sku/queryListByIds")
    public List<SkuProductVo> queryListByIds(@RequestBody List<Integer> ids) {
        return skuService.queryListByIds(ids);
    }
}
