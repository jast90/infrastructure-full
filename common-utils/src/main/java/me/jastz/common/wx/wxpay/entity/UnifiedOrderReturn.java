package me.jastz.common.wx.wxpay.entity;

import com.github.wxpay.sdk.WXPayConstants;

import java.util.Map;
import java.util.Objects;

public class UnifiedOrderReturn {
    private String returnCode;
    private String returnMsg;

    public UnifiedOrderReturn() {
    }

    public UnifiedOrderReturn(Map<String, String> map) {
        this.returnCode = map.get("return_code");
        this.returnMsg = map.get("return_msg");
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public static UnifiedOrderReturn mapTo(Map<String, String> map) {
        UnifiedOrderReturn unifiedOrderReturn;
        if (Objects.equals(map.get("return_code"), WXPayConstants.SUCCESS)) {
            if (Objects.equals(map.get("result_code"), WXPayConstants.SUCCESS)) {
                unifiedOrderReturn = new UnifiedOrderReturnAndResultSuccess();
            } else {
                unifiedOrderReturn = new UnifiedOrderReturnSuccess(map);
            }
        } else {
            unifiedOrderReturn = new UnifiedOrderReturn(map);
        }

        return unifiedOrderReturn;
    }
}
