package cn.jastz.payment.service.pay;

import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;

/**
 * @author zhiwen
 */
public interface TradeService {

    ThirdPayCreateTradeResult createTrade(ThirdPayCreateTradeParam thirdPayCreateTradeParam);
}
