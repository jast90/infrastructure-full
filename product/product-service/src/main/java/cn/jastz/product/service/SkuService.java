package cn.jastz.product.service;

import cn.jastz.product.entity.ProductSkuAttrRef;
import cn.jastz.product.entity.Sku;
import cn.jastz.product.entity.SkuAttrRef;
import cn.jastz.product.form.SkuAddForm;
import cn.jastz.product.form.SkuAttrRefBatchAddForm;
import cn.jastz.product.mapper.ProductSkuAttrRefMapper;
import cn.jastz.product.mapper.SkuAttrRefMapper;
import cn.jastz.product.mapper.SkuMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhiwen
 */
@Service
public class SkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SkuAttrRefMapper skuAttrRefMapper;

    @Autowired
    private ProductSkuAttrRefMapper productSkuAttrRefMapper;

    public boolean addSku(SkuAddForm skuAddForm) {
        return skuMapper.insert(skuAddForm.to()) > 0;
    }

    public boolean batchAddSkuAttrRef(SkuAttrRefBatchAddForm skuAttrRefBatchAddForm) {
        List<SkuAttrRef> skuAttrRefList = skuAttrRefBatchAddForm.toSkuAttrRefList();
        int count = skuAttrRefMapper.batchInsert(skuAttrRefList);
        System.out.println("1批量插入影响条数：" + count);
        if (count > 0) {
            List<ProductSkuAttrRef> productSkuAttrRefList = Lists.newArrayList();
            for (SkuAttrRef skuAttrRef : skuAttrRefList) {
                Sku sku = skuMapper.selectByPrimaryKey(skuAttrRef.getSkuId());
                if (sku == null) {
                    continue;
                }
                ProductSkuAttrRef productSkuAttrRef = new ProductSkuAttrRef();
                productSkuAttrRef.setAppId(skuAttrRef.getAppId());
                productSkuAttrRef.setCreatedTime(new Date());
                productSkuAttrRef.setProductId(sku.getProductId());
                productSkuAttrRef.setSkuAttrId(skuAttrRef.getSkuAttrId());
                productSkuAttrRef.setSkuAttrValue(skuAttrRef.getSkuAttrValue());
                productSkuAttrRefList.add(productSkuAttrRef);
            }
            count = productSkuAttrRefMapper.batchInsert(productSkuAttrRefList);
            System.out.println("2批量插入影响条数：" + count);
        }
        return count > 0;
    }
}
