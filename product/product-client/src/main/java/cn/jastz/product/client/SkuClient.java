package cn.jastz.product.client;

import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("product")
public interface SkuClient {

    @PostMapping("sku")
    BaseResult addSku(@RequestBody SkuAddForm skuAddForm);

    @PostMapping("sku/attr/ref")
    BaseResult batchAddSkuAttrRef(@RequestBody SkuAttrRefBatchAddForm skuAttrRefBatchAddForm);
}
