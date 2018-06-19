package cn.jastz.product.form;

/**
 * @author zhiwen
 */
public class SkuAttrRefAddForm {
    private Integer skuId;

    private Integer skuAttrId;

    private String skuAttrValue;

    private String appId;

    public SkuAttrRefAddForm() {
    }

    public SkuAttrRefAddForm(Integer skuId, Integer skuAttrId, String skuAttrValue, String appId) {
        this.skuId = skuId;
        this.skuAttrId = skuAttrId;
        this.skuAttrValue = skuAttrValue;
        this.appId = appId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public String getSkuAttrValue() {
        return skuAttrValue;
    }

    public void setSkuAttrValue(String skuAttrValue) {
        this.skuAttrValue = skuAttrValue;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


}
