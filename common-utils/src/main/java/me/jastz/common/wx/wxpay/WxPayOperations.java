package me.jastz.common.wx.wxpay;

import me.jastz.common.wx.wxpay.entity.UnifiedOrderForm;
import me.jastz.common.wx.wxpay.entity.UnifiedOrderReturn;

public interface WxPayOperations {

    UnifiedOrderReturn unifiedOrder(UnifiedOrderForm unifiedOrderForm);
}
