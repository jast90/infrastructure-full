package cn.jastz.payment;

import cn.jastz.payment.entity.PaymentOrder;
import cn.jastz.payment.mapper.PaymentOrderMapper;
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

}
