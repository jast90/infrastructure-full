package cn.jastz.payment.config;

import cn.jastz.open.client.AppPayConfigClient;
import cn.jastz.open.entity.AppPayConfig;
import cn.jastz.open.entity.AppPayConfigDetails;
import cn.jastz.open.enums.AttrName;
import cn.jastz.open.enums.PayPlatform;
import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhiwen
 */
@Component
public class MyWxPayConfig implements WXPayConfig {
    @Autowired
    private AppPayConfigClient appPayConfigClient;

    @Override
    public String getAppID() {
        return getAppPayConfig().get(AttrName.app_id);
    }

    @Override
    public String getMchID() {
        return getAppPayConfig().get(AttrName.mch_id);

    }

    @Override
    public String getKey() {
        return getAppPayConfig().get(AttrName.pay_key);
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 60000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 60000;
    }

    public String getAttrValue(AttrName attrName) {
        return getAppPayConfig().get(attrName.name());
    }

    private Map<String, String> getAppPayConfig() {
        AppPayConfig appPayConfig = appPayConfigClient.getByAppIdAndPayPlatform(PayPlatform.wechat_pay);
        Map<String, String> map = appPayConfig.getAppPayConfigDetailsList().stream().collect(Collectors.toMap(AppPayConfigDetails::getAttrName, AppPayConfigDetails::getAttrValue));
        return map;
    }
}
