package cn.jastz.product.form;

import cn.jastz.product.entity.SkuCategory;

import java.util.Date;

/**
 * @author zhiwen
 */
public class SkuCategoryAddForm {
    private String appId;
    private String categoryName;
    private String categoryDesc;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public SkuCategory to() {
        SkuCategory skuCategory = new SkuCategory();
        skuCategory.setAppId(getAppId());
        skuCategory.setCategoryName(getCategoryName());
        skuCategory.setCategoryDesc(getCategoryDesc());
        skuCategory.setCreatedTime(new Date());
        return skuCategory;
    }
}
