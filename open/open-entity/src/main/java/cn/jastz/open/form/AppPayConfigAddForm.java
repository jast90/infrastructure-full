package cn.jastz.open.form;

import cn.jastz.open.entity.AppPayConfig;
import cn.jastz.open.entity.AppPayConfigDetails;
import cn.jastz.open.enums.PayPlatform;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhiwen
 */
public class AppPayConfigAddForm {
    private String appId;
    private PayPlatform payPlatform;
    private List<AppPayConfigDetailsAddForm> appPayConfigDetailsAddForms;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public PayPlatform getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(PayPlatform payPlatform) {
        this.payPlatform = payPlatform;
    }

    public List<AppPayConfigDetailsAddForm> getAppPayConfigDetailsAddForms() {
        return appPayConfigDetailsAddForms;
    }

    public void setAppPayConfigDetailsAddForms(List<AppPayConfigDetailsAddForm> appPayConfigDetailsAddForms) {
        this.appPayConfigDetailsAddForms = appPayConfigDetailsAddForms;
    }

    public AppPayConfig toAppPayConfig() {
        AppPayConfig appPayConfig = new AppPayConfig();
        appPayConfig.setAppId(getAppId());
        appPayConfig.setPayPlatform(getPayPlatform().name());
        return appPayConfig;
    }

    public List<AppPayConfigDetails> toAppPayConfigDetails() {
        List<AppPayConfigDetails> list = Lists.newArrayList();
        getAppPayConfigDetailsAddForms().forEach(appPayConfigDetailsAddForm -> {
            AppPayConfigDetails appPayConfigDetails = new AppPayConfigDetails();
            appPayConfigDetails.setAttrName(appPayConfigDetailsAddForm.getAttrName().name());
            appPayConfigDetails.setAttrValue(appPayConfigDetailsAddForm.getAttrValue());
            list.add(appPayConfigDetails);
        });
        return list;
    }
}
