package cn.jastz.payment.entity.pay;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiwen
 */
public class ThirdPayCreateTradeParam {
    private String appId;
    private String sign;
    /**
     * title
     * 对应微信的body
     * 对应支付宝的subject
     */
    private String title;
    private String outTradeNo;
    /**
     * 单位：元
     */
    private BigDecimal totalFee;


    /**
     * 微信专有
     * mch_id
     * nonce_str
     * spbill_create_ip
     * trade_type
     * notifyUrl
     */
    private String mchId;
    private String nonceStr;
    private String spbillCreateIp;
    private String tradeType;
    private String notifyUrl;

    /**
     * 支付宝专有
     * method
     * charset
     * sign_type
     * timestamp
     * version
     */

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Map<String, String> toWxPayMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("appid", getAppId());
        map.put("mch_id", getMchId());
        map.put("nonce_str", getNonceStr());
        map.put("notify_url", getNotifyUrl());
        map.put("out_trade_no", getOutTradeNo());
        map.put("sign", getSign());
        map.put("spbill_create_ip", getSpbillCreateIp());
        map.put("body", getTitle());
        map.put("trade_type", getTradeType());
        map.put("total_fee", getTotalFee().toString());
        return map;
    }
}
