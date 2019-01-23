package cn.jastz.payment.entity.pay;

import java.math.BigDecimal;

/**
 * @author zhiwen
 */
public class ThirdPayCreateTradeParam {
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
    private String spbillCreateIp;
    private String notifyUrl;
    private String tradeType;
    private String openId;

    /**
     * 支付宝专有
     * method
     * charset
     * sign_type
     * timestamp
     * version
     */


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

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
