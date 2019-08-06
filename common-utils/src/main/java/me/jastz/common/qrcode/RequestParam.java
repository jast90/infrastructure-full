package me.jastz.common.qrcode;

/**
 * @author zhiwen
 * @date 2017/10/31
 */
public interface RequestParam {
    String getSign();

    String getAppid();

    String getMchId();

    String getProductId();

    String getTimestamp();

    String getNonceStr();
}
