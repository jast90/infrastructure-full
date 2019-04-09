package cn.jastz.payment;

import cn.jastz.payment.entity.PaymentOrder;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeParam;
import cn.jastz.payment.entity.pay.ThirdPayCreateTradeResult;
import cn.jastz.payment.entity.pay.ThirdPayMethod;
import cn.jastz.payment.mapper.PaymentOrderMapper;
import cn.jastz.payment.service.pay.TradeServiceFactory;
import me.jastz.common.json.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentApplicationTests {
    @Autowired
    private PaymentOrderMapper orderMapper;

    @Autowired
    private TradeServiceFactory tradeServiceFactory;

    @Test
    public void contextLoads() {
        PaymentOrder order = new PaymentOrder();
        order.setOrderNo(UUID.randomUUID().toString());
        order.setAccountId(1);
        order.setPaymentType("wxpay");
        order.setOrderStatus("unpaid");
        order.setTotalAmount(new BigDecimal(10));
        order.setPayAmount(new BigDecimal(10));
        int i = orderMapper.insert(order);
        System.out.println(i);
        Assert.assertTrue(order.getOrderId() > 0);
    }

    @Test
    public void createTrade() {
        ThirdPayCreateTradeParam thirdPayCreateTradeParam = new ThirdPayCreateTradeParam();
        thirdPayCreateTradeParam.setSpbillCreateIp("192.168.1.1");
        thirdPayCreateTradeParam.setTotalFee(new BigDecimal(0.01));
        thirdPayCreateTradeParam.setTradeType("JSAPI");
        thirdPayCreateTradeParam.setNotifyUrl("http://tpaygate.aicebox.com/WECHAT_PAY_JSAPI/payment/callback");
        thirdPayCreateTradeParam.setOpenId("oqaKZ5WhRHu_PHVJPu7WbQUG3rjI");
        ThirdPayCreateTradeResult thirdPayCreateTradeResult = tradeServiceFactory.createTradeService(ThirdPayMethod.WECHAT_PAY).createTrade(thirdPayCreateTradeParam);
        System.out.println(JsonUtil.objectToPrettyJson(thirdPayCreateTradeResult));
    }

}
