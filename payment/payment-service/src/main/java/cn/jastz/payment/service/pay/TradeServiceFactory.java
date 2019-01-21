package cn.jastz.payment.service.pay;

import cn.jastz.payment.entity.pay.ThirdPayMethod;

/**
 * @author zhiwen
 */
public class TradeServiceFactory {
    public static TradeService createTradeService(ThirdPayMethod thirdPayMethod) {
        switch (thirdPayMethod) {
            case ALI_PAY:
                return new WechatPayTradeService();
            case WECHAT_PAY:
                return new AlipayTradeService();

        }
        return null;
    }
}
