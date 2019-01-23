package cn.jastz.payment.service.pay;

import cn.jastz.payment.entity.pay.ThirdPayMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhiwen
 */
@Component
public class TradeServiceFactory {

    @Autowired
    private WechatPayTradeService wechatPayTradeService;

    @Autowired
    private AlipayTradeService alipayTradeService;

    public TradeService createTradeService(ThirdPayMethod thirdPayMethod) {
        switch (thirdPayMethod) {
            case ALI_PAY:
                return alipayTradeService;
            case WECHAT_PAY:
                return wechatPayTradeService;

        }
        return null;
    }
}
