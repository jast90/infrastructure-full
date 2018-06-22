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
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
        Set<String> keys = Sets.newHashSet();
        if (count > 0) {
            List<ProductSkuAttrRef> productSkuAttrRefList = Lists.newArrayList();
            for (SkuAttrRef skuAttrRef : skuAttrRefList) {
                Sku sku = skuMapper.selectByPrimaryKey(skuAttrRef.getSkuId());
                if (sku == null) {
                    continue;
                }
                //数据库存在
                ProductSkuAttrRef ref = productSkuAttrRefMapper.selectByProductIdAndSkuAttrIdAndSkuAttrValue(sku.getProductId(), skuAttrRef.getSkuAttrId(), skuAttrRef.getSkuAttrValue());
                if (ref != null) {
                    continue;
                }
                //如果一次性添加时去重后添加
                String key = String.format("%s-%s-%s", sku.getProductId(), skuAttrRef.getSkuAttrId(), skuAttrRef.getSkuAttrValue());
                if (keys.contains(key)) {
                    continue;
                } else {
                    keys.add(key);
                }
                ProductSkuAttrRef productSkuAttrRef = new ProductSkuAttrRef();
                productSkuAttrRef.setAppId(skuAttrRef.getAppId());
                productSkuAttrRef.setCreatedTime(new Date());
                productSkuAttrRef.setProductId(sku.getProductId());
                productSkuAttrRef.setSkuAttrId(skuAttrRef.getSkuAttrId());
                productSkuAttrRef.setSkuAttrValue(skuAttrRef.getSkuAttrValue());
                productSkuAttrRefList.add(productSkuAttrRef);
            }
            if (CollectionUtils.isEmpty(productSkuAttrRefList) == false) {
                count = productSkuAttrRefMapper.batchInsert(productSkuAttrRefList);
                System.out.println("2批量插入影响条数：" + count);
            }
        }
        return count > 0;
    }

    public List<Sku> queryListByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        return skuMapper.selectListByIds(ids);
    }
}
