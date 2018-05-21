package cn.jastz.payment.mapper;

import cn.jastz.payment.entity.PaymentOrder;
import java.util.List;

public interface PaymentOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(PaymentOrder record);

    PaymentOrder selectByPrimaryKey(Integer orderId);

    List<PaymentOrder> selectAll();

    int updateByPrimaryKey(PaymentOrder record);
}