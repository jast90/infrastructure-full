package cn.jastz.payment.service;

import cn.jastz.payment.entity.PaymentOrder;
import cn.jastz.payment.entity.PaymentOrderItem;
import cn.jastz.payment.enums.OrderStatus;
import cn.jastz.payment.mapper.PaymentOrderItemMapper;
import cn.jastz.payment.mapper.PaymentOrderMapper;
import cn.jastz.payment.vo.OrderItemVO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author zhiwen
 */
@Service
public class PaymentOrderService {
    @Autowired
    private PaymentOrderMapper paymentOrderMapper;

    @Autowired
    private PaymentOrderItemMapper paymentOrderItemMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public int saveOneProductOrder(int accountId, int productId, String productName, BigDecimal payAmount) {
        PaymentOrder order = new PaymentOrder(getOrderNo(), payAmount, payAmount, OrderStatus.unpaid.name(), accountId);
        paymentOrderMapper.insert(order);
        PaymentOrderItem item = new PaymentOrderItem(order.getOrderId(), productId, productName, 1, payAmount);
        paymentOrderItemMapper.insert(item);
        return order.getOrderId();

    }

    @Transactional(rollbackFor = RuntimeException.class)
    public int saveMultiProductOrder(int accountId, List<OrderItemVO> orderItemVOS, BigDecimal payAmount) {
        PaymentOrder order = new PaymentOrder(getOrderNo(), payAmount, payAmount, OrderStatus.unpaid.name(), accountId);
        paymentOrderMapper.insert(order);
        List<PaymentOrderItem> items = Lists.newArrayList();
        for (OrderItemVO orderItemVO : orderItemVOS) {
            PaymentOrderItem item = new PaymentOrderItem(order.getOrderId(), orderItemVO.getProductId(), orderItemVO.getProductName(), orderItemVO.getQty(), orderItemVO.getPrice());
            items.add(item);
        }
        paymentOrderItemMapper.batchInsert(items);
        return order.getOrderId();

    }

    public String getOrderNo() {
        return UUID.randomUUID().toString();
    }
}
