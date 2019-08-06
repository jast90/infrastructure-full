package me.jastz.common.alipay.domain;

/**
 * @author zhiwen
 */
public class TradeCreateParam extends CommonParam {
    private String out_trade_no;
    private String seller_id;
    private String total_amount;
    private String discountable_amount;
    private String subject;
    private String body;
    private String buyer_id;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getDiscountable_amount() {
        return discountable_amount;
    }

    public void setDiscountable_amount(String discountable_amount) {
        this.discountable_amount = discountable_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }
}
