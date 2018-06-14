package cn.jastz.product.form;

import cn.jastz.product.entity.SkuAttr;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhiwen
 */
public class SkuAttrAddForm {
    private String attrName;

    private String attrCode;

    private String attrDesc;

    private Integer skuCategoryId;

    private String appId;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    public Integer getSkuCategoryId() {
        return skuCategoryId;
    }

    public void setSkuCategoryId(Integer skuCategoryId) {
        this.skuCategoryId = skuCategoryId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public SkuAttr to() {
        SkuAttr skuAttr = new SkuAttr();
        BeanUtils.copyProperties(this, skuAttr);
        skuAttr.setCreatedTime(new Date());
        return skuAttr;
    }

}
