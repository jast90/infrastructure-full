package cn.jastz.payment.service.pay;

import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import org.springframework.stereotype.Service;

/**
 * @author zhiwen
 */
@Service
public class AlipayTradeService implements TradeService{


    @Override
    public ThirdPayCreateTradeResult createTrade(ThirdPayCreateTradeParam thirdPayCreateTradeParam) {
        return null;
    }
}
