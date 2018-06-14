package cn.jastz.product.service;

import cn.jastz.product.entity.SkuAttr;
import cn.jastz.product.form.SkuAttrAddForm;
import cn.jastz.product.mapper.SkuAttrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhiwen
 */
@Service
public class SkuAttrService {

    @Autowired
    private SkuAttrMapper skuAttrMapper;

    public boolean addSkuAttr(SkuAttrAddForm skuAttrAddForm) {
        return skuAttrMapper.insert(skuAttrAddForm.to()) > 0;
    }

    public List<SkuAttr> queryAll(String appId) {
        return skuAttrMapper.selectAllByAppId(appId);
    }
}
