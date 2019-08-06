package me.jastz.common.wx;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import me.jastz.common.wx.wxpay.WxPayOperations;
import me.jastz.common.wx.wxpay.WxPayOperationsImpl;

public class WxTemplates {

    private WXPay wxPay;

    private WXPayConfig wxPayConfig;

    public WxTemplates(WXPayConfig wxPayConfig) {
        this.wxPay = new WXPay(wxPayConfig);
    }

    public WxPayOperations wxPayOperations() {
        return new WxPayOperationsImpl(wxPay);
    }


    public WXPayConfig getWxPayConfig() {
        return wxPayConfig;
    }

}
