package me.jastz.common.wx.wxpay.entity;

import com.google.common.collect.Maps;
import me.jastz.common.wx.wxpay.WxTradeType;

import java.util.Map;

public class UnifiedOrderForm {
    private String appId;
    private String mchId;
    private String subAppId;
    private String subMchId;
    private String deviceInfo;
    private String nonceString;
    private String sign;
    private String signType;
    private String body;
    private String detail;
    private String attach;
    private String outTradeNo;
    private String feeType;
    private int totalFee;
    private String spbillCreateIp;
    private String timeStart;
    private String timeExpire;
    private String goodsTag;
    private String notifyUrl;
    private String tradeType;
    private String productId;
    private String limitPay;
    private String openId;
    private String subOpenId;
    private String sceneInfo;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceString() {
        return nonceString;
    }

    public void setNonceString(String nonceString) {
        this.nonceString = nonceString;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    public static class UnifiedOrderFormBuilder {
        private static UnifiedOrderFormBuilder instance = new UnifiedOrderFormBuilder();
        private UnifiedOrderForm unifiedOrderForm = new UnifiedOrderForm();

        private UnifiedOrderFormBuilder() {
        }

        public static UnifiedOrderFormBuilder getInstance() {
            return instance;
        }

        public UnifiedOrderFormBuilder setAppId(String appId) {
            unifiedOrderForm.setAppId(appId);
            return this;
        }

        public UnifiedOrderFormBuilder setMchId(String subMchId) {
            unifiedOrderForm.setMchId(subMchId);
            return this;
        }

        public UnifiedOrderFormBuilder setNonceString(String nonceString) {
            unifiedOrderForm.setNonceString(nonceString);
            return this;
        }

        public UnifiedOrderFormBuilder setSign(String sign) {
            unifiedOrderForm.setSign(sign);
            return this;
        }

        public UnifiedOrderFormBuilder setBody(String body) {
            unifiedOrderForm.setBody(body);
            return this;
        }

        public UnifiedOrderFormBuilder setOutTradeNo(String outTradeNo) {
            unifiedOrderForm.setOutTradeNo(outTradeNo);
            return this;
        }

        public UnifiedOrderFormBuilder setTotalFee(int totalFee) {
            unifiedOrderForm.setTotalFee(totalFee);
            return this;
        }

        public UnifiedOrderFormBuilder setSpbillCreateIp(String spbillCreateIp) {
            unifiedOrderForm.setSpbillCreateIp(spbillCreateIp);
            return this;
        }

        public UnifiedOrderFormBuilder setNotifyUrl(String notifyUrl) {
            unifiedOrderForm.setNotifyUrl(notifyUrl);
            return this;
        }

        public UnifiedOrderFormBuilder setTradeType(WxTradeType wxTradeType) {
            unifiedOrderForm.setTradeType(wxTradeType.name());
            return this;
        }

        public UnifiedOrderForm build() {
            return unifiedOrderForm;
        }

    }

    public Map<String, String> toMap() {
        Map<String, String> map = Maps.newHashMap();
        if (getAppId() != null) {
            map.put("appid", getAppId());
        }
        if (getMchId() != null) {
            map.put("mch_id", getMchId());
        }
        if (getDeviceInfo() != null) {
            map.put("device_info", getDeviceInfo());
        }
        if (getNonceString() != null) {
            map.put("nonce_str", getNonceString());
        }
        if (getSign() != null) {
            map.put("sign", getSign());
        }

        if (getSignType() != null) {
            map.put("sign_type", getSignType());
        }
        if (getBody() != null) {
            map.put("body", getBody());
        }
        if (getDetail() != null) {
            map.put("detail", getDetail());
        }
        if (getAttach() != null) {
            map.put("attach", getAttach());
        }
        if (getOutTradeNo() != null) {
            map.put("out_trade_no", getOutTradeNo());
        }
        if (getFeeType() != null) {
            map.put("fee_type", getFeeType());
        }
        map.put("total_fee", String.valueOf(getTotalFee()));
        if (getSpbillCreateIp() != null) {
            map.put("spbill_create_ip", getSpbillCreateIp());
        }
        if (getTimeStart() != null) {
            map.put("time_start", getTimeStart());
        }
        if (getTimeExpire() != null) {
            map.put("time_expire", getTimeExpire());
        }
        if (getGoodsTag() != null) {
            map.put("goods_tag", getGoodsTag());
        }
        if (getNotifyUrl() != null) {
            map.put("notify_url", getNotifyUrl());
        }
        if (getTradeType() != null) {
            map.put("trade_type", getTradeType());
        }
        if (getProductId() != null) {
            map.put("product_id", getProductId());
        }

        if (getLimitPay() != null) {
            map.put("limit_pay", getLimitPay());
        }
        if (getOpenId() != null) {
            map.put("openid", getOpenId());
        }
        if (getSceneInfo() != null) {
            map.put("scene_info", getSceneInfo());
        }
        return map;
    }

}
