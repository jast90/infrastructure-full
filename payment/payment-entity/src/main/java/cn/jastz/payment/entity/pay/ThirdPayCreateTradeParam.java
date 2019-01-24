package cn.jastz.payment.entity.pay;

import cn.jastz.payment.vo.OrderItemVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhiwen
 */
public class ThirdPayCreateTradeParam {
    /**
     * title
     * 对应微信的body
     * 对应支付宝的subject
     */

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

    private int accountId;
    private List<OrderItemVO> orderItemVOS;


    public String getTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        for (OrderItemVO orderItemVO : orderItemVOS) {
            stringBuilder.append(String.format("%s X %s", orderItemVO.getProductName(), orderItemVO.getQty()));
        }
        return stringBuilder.toString();
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<OrderItemVO> getOrderItemVOS() {
        return orderItemVOS;
    }

    public void setOrderItemVOS(List<OrderItemVO> orderItemVOS) {
        this.orderItemVOS = orderItemVOS;
    }
}
