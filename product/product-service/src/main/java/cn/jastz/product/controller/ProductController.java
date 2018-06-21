package cn.jastz.product.controller;

import cn.jastz.product.form.ProductAddForm;
import cn.jastz.product.result.ProductResult;
import cn.jastz.product.service.ProductService;
import cn.jastz.product.vo.ProductSkuVo;
import cn.jastz.product.vo.ProductVo;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("product")
    public IResult addProduct(@RequestBody ProductAddForm productAddForm) {
        if (productService.addProduct(productAddForm)) {
            return ProductResult.SUCCESS;
        } else {
            return ProductResult.FAIL;
        }
    }

    @GetMapping("product/{productId}")
    public ProductVo queryProductVo(@PathVariable("productId") int productId) {
        return productService.queryProductVo(productId);
    }

    @GetMapping("product/productSkuVoList")
    public List<ProductSkuVo> queryProductSkuVoList() {
        return productService.queryAllProductSkuVoList();
    }
}
