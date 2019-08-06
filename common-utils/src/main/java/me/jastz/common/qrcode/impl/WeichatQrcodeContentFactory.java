package me.jastz.common.qrcode.impl;

import me.jastz.common.http.AppType;
import me.jastz.common.qrcode.QrcodeContentFactory;
import me.jastz.common.qrcode.RequestParam;

/**
 * @author zhiwen
 * @date 2017/10/31
 */
public class WeichatQrcodeContentFactory implements QrcodeContentFactory {
    @Override
    public String generateContent(AppType appType, RequestParam requestParam) {
        return String.format(
                "weixin://wxpay/bizpayurl?sign=%s&appid=%s&mch_id=%s&product_id=%s&time_stamp=%s&nonce_str=%s"
                , requestParam.getSign()
                , requestParam.getAppid()
                , requestParam.getMchId()
                , requestParam.getProductId()
                , requestParam.getTimestamp()
                , requestParam.getNonceStr());
    }
}
