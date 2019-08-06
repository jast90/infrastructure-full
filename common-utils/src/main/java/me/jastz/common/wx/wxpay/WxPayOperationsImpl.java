package me.jastz.common.wx.wxpay;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderForm;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class WxPayOperationsImpl implements WxPayOperations {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private WXPay wxPay;

    public WxPayOperationsImpl(WXPay wxPay) {
        this.wxPay = wxPay;
    }

    @Override
    public UnifiedOrderReturn unifiedOrder(UnifiedOrderForm unifiedOrderForm) {
        try {
            UnifiedOrderReturn unifiedOrderReturn = UnifiedOrderReturn.mapTo(wxPay.unifiedOrder(unifiedOrderForm.toMap()));
            if (Objects.equals(unifiedOrderReturn.getReturnCode(), WXPayConstants.SUCCESS)) {
                logger.debug("wxpay unified order return:{}", JsonUtil.objectToJson(unifiedOrderReturn));
            } else {
                logger.error("wxpay unified order return:{}", JsonUtil.objectToJson(unifiedOrderReturn));
            }
            return unifiedOrderReturn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
