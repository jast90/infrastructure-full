package cn.jastz.product.service;

import cn.jastz.product.form.SkuCategoryAddForm;
import cn.jastz.product.mapper.SkuCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhiwen
 */
@Service
public class SkuCategoryService {
    @Autowired
    private SkuCategoryMapper skuCategoryMapper;

    /**
     * service 中传递form是为了方便单元测试
     *
     * @param skuCategoryAddForm
     * @return
     */
    public boolean addSkuCategory(SkuCategoryAddForm skuCategoryAddForm) {
        return skuCategoryMapper.insert(skuCategoryAddForm.to()) > 0;
    }

}
