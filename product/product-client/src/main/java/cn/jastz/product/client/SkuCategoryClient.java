package cn.jastz.product.client;

import cn.jastz.product.entity.SkuCategory;
import cn.jastz.product.form.SkuCategoryAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("product")
public interface SkuCategoryClient {

    @PostMapping("sku/category")
    BaseResult addSkuCategory(@RequestBody SkuCategoryAddForm addForm);

    @GetMapping("sku/category/list")
    List<SkuCategory> list();
}
