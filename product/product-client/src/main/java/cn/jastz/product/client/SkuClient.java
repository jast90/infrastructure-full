package cn.jastz.product.client;

import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import cn.jastz.product.vo.SkuProductVo;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("product")
public interface SkuClient {

    @PostMapping("sku")
    BaseResult addSku(@RequestBody SkuAddForm skuAddForm);

    @PostMapping("sku/attr/ref")
    BaseResult batchAddSkuAttrRef(@RequestBody SkuAttrRefBatchAddForm skuAttrRefBatchAddForm);

    @PostMapping("sku/queryListByIds")
    List<SkuProductVo> queryListByIds(@RequestBody List<Integer> integers);
}
