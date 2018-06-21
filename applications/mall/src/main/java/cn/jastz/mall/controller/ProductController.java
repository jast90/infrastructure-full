package cn.jastz.mall.controller;

import cn.jastz.product.client.ProductClient;
import cn.jastz.product.vo.ProductSkuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhiwen
 */
@Controller
public class ProductController {
    @Autowired
    private ProductClient productClient;

    @ResponseBody
    @GetMapping("product/sku/vo/list")
    public List<ProductSkuVo> queryProductSkuVoList() {
        return productClient.queryProductSkuVoList();
    }
}
