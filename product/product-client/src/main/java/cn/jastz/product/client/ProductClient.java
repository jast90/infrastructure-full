package cn.jastz.product.client;

import cn.jastz.product.form.SkuCategoryAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("product")
public interface ProductClient {
    @PostMapping("sku/category")
    BaseResult addSkuCategory(@RequestBody SkuCategoryAddForm addForm);
}
