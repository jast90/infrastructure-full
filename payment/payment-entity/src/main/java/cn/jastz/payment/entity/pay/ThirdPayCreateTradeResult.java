package cn.jastz.payment.entity.pay;

/**
 * @author zhiwen
 */
public class ThirdPayCreateTradeResult {
    private ThirdPayMethod thirdPayMethod;
    private AliPayTradeCreateResult aliPayTradeCreateResult;
    private WechatPayUnifieOrderResult wechatPayUnifieOrderResult;

    public ThirdPayMethod getThirdPayMethod() {
        return thirdPayMethod;
    }

    public void setThirdPayMethod(ThirdPayMethod thirdPayMethod) {
        this.thirdPayMethod = thirdPayMethod;
    }

    public AliPayTradeCreateResult getAliPayTradeCreateResult() {
        return aliPayTradeCreateResult;
    }

    public void setAliPayTradeCreateResult(AliPayTradeCreateResult aliPayTradeCreateResult) {
        this.aliPayTradeCreateResult = aliPayTradeCreateResult;
    }

    public WechatPayUnifieOrderResult getWechatPayUnifieOrderResult() {
        return wechatPayUnifieOrderResult;
    }

    public void setWechatPayUnifieOrderResult(WechatPayUnifieOrderResult wechatPayUnifieOrderResult) {
        this.wechatPayUnifieOrderResult = wechatPayUnifieOrderResult;
    }
}
