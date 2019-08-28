package cn.jastz.product.client;

import cn.jastz.product.form.ProductAddForm;
import cn.jastz.product.vo.ProductSkuVo;
import cn.jastz.product.vo.ProductVo;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("product")
public interface ProductClient {

    @PostMapping("product")
    BaseResult addProduct(@RequestBody ProductAddForm productAddForm);

    @GetMapping("product/{productId}")
    ProductVo queryProductVo(@PathVariable("productId") int productId);

    @GetMapping("product/productSkuVoList")
    List<ProductSkuVo> queryProductSkuVoList();
}
