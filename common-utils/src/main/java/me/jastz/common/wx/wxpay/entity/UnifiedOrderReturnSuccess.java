package me.jastz.common.wx.wxpay.entity;

import java.util.Map;

public class UnifiedOrderReturnSuccess extends UnifiedOrderReturn {
    private String appId;
    private String mchId;
    private String subAppId;
    private String subMchId;
    private String deviceInfo;
    private String nonceStr;
    private String sign;
    private String resultCode;
    private String errCode;
    private String errCodeDes;

    public UnifiedOrderReturnSuccess() {
    }

    public UnifiedOrderReturnSuccess(Map<String, String> map) {
        super(map);
        this.appId = (String) map.get("app_id");
        this.mchId = (String) map.get("mch_id");
        this.subAppId = (String) map.get("sub_app_id");
        this.subMchId = (String) map.get("sub_mch_id");
        this.deviceInfo = (String) map.get("device_info");
        this.nonceStr = (String) map.get("nonce_str");
        this.sign = (String) map.get("sign");
        this.resultCode = (String) map.get("result_code");
        this.errCode = (String) map.get("err_code");
        this.errCodeDes = (String) map.get("err_code_des");
    }

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

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }
}
