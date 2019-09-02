package cn.jastz.mall.api.controller;

import cn.jastz.payment.client.PaymentClient;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import cn.jastz.payment.entity.pay.ThirdPayMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
public class OrderController {
   /* @Autowired
    private PaymentClient paymentClient;

    @PostMapping("order")
    public ThirdPayCreateTradeResult createOrder(ThirdPayCreateTradeParam thirdPayCreateTradeParam) {
        return paymentClient.createThirdTrade(ThirdPayMethod.WECHAT_PAY.name(), thirdPayCreateTradeParam);
    }*/
}
