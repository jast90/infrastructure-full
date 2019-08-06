package me.jastz.common.wx;

import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

/**
 * @author zhiwen
 */
public class DefaultWXPayConfig implements WXPayConfig {

    @Value("${wx.pay.appID}")
    private String appID;
    @Value("${wx.pay.mchID}")
    private String mchID;
    @Value("${wx.pay.key}")
    private String key;
    private InputStream certStream;
    @Value("${wx.pay.certStreamFileName:''}")
    private String certStreamFileName;
    @Value("${wx.pay.httpConnectTimeoutMs:60000}")
    private int httpConnectTimeoutMs;
    @Value("${wx.pay.httpReadTimeoutMs:60000}")
    private int httpReadTimeoutMs;

    @Override
    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    @Override
    public String getMchID() {
        return mchID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public InputStream getCertStream() {
        return certStream;
    }

    public void setCertStream(InputStream certStream) {
        this.certStream = certStream;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return httpConnectTimeoutMs;
    }

    public void setHttpConnectTimeoutMs(int httpConnectTimeoutMs) {
        this.httpConnectTimeoutMs = httpConnectTimeoutMs;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return httpReadTimeoutMs;
    }

    public void setHttpReadTimeoutMs(int httpReadTimeoutMs) {
        this.httpReadTimeoutMs = httpReadTimeoutMs;
    }
}
