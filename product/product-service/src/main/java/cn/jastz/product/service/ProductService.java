package cn.jastz.product.service;

import cn.jastz.product.form.ProductAddForm;
import cn.jastz.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
