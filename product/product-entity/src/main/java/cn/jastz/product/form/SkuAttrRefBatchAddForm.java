package cn.jastz.product.form;

import cn.jastz.product.entity.SkuAttrRef;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * @author zhiwen
 */
public class SkuAttrRefBatchAddForm {
    private List<SkuAttrRefAddForm> list;

    public List<SkuAttrRefAddForm> getList() {
        return list;
    }

    public void setList(List<SkuAttrRefAddForm> list) {
        this.list = list;
    }

    public List<SkuAttrRef> toSkuAttrRefList() {
        List<SkuAttrRef> skuAttrReflist = Lists.newArrayList();
        SkuAttrRef skuAttrRef;
        Date date = new Date();
        for (SkuAttrRefAddForm skuAttrRefAddForm : list) {
            skuAttrRef = new SkuAttrRef();
            BeanUtils.copyProperties(skuAttrRefAddForm, skuAttrRef);
            skuAttrRef.setCreatedTime(date);
            skuAttrReflist.add(skuAttrRef);
        }
        return skuAttrReflist;
    }
}
