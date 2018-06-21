package cn.jastz.product.service;

import cn.jastz.product.form.ProductAddForm;
import cn.jastz.product.mapper.ProductMapper;
import cn.jastz.product.vo.ProductSkuVo;
import cn.jastz.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhiwen
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public boolean addProduct(ProductAddForm productAddForm) {
        return productMapper.insert(productAddForm.to()) > 0;
    }

    public ProductVo queryProductVo(Integer productId) {
        return productMapper.queryProductVoByPrimaryKey(productId);
    }

    public List<ProductSkuVo> queryAllProductSkuVoList() {
        return productMapper.queryAllProductSkuVo();
    }
}
