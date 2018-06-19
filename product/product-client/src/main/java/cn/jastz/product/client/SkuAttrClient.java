package cn.jastz.product.client;

import cn.jastz.product.entity.SkuAttr;
import cn.jastz.product.form.SkuAttrAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("product")
public interface SkuAttrClient {
    @PostMapping("sku/attr")
    BaseResult addSkuAttr(@RequestBody SkuAttrAddForm skuAttrAddForm);

    @GetMapping("sku/attr/list")
    List<SkuAttr> list();
}
