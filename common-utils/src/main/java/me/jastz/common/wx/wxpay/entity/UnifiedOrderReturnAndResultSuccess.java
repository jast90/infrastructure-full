package me.jastz.common.wx.wxpay.entity;

import java.util.Map;

public class UnifiedOrderReturnAndResultSuccess extends UnifiedOrderReturnSuccess{
    private String tradeType;
    private String prepayId;
    private String codeUrl;
    public UnifiedOrderReturnAndResultSuccess() {
    }

    public UnifiedOrderReturnAndResultSuccess(Map<String, String> map) {
        super(map);
        this.tradeType = (String)map.get("trade_type");
        this.prepayId = (String)map.get("prepay_id");
        this.codeUrl = (String)map.get("code_url");
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
