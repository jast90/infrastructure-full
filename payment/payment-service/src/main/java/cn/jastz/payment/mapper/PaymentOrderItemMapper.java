package cn.jastz.payment.mapper;

import cn.jastz.payment.entity.PaymentOrderItem;

import java.util.List;

public interface PaymentOrderItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(PaymentOrderItem record);

    int batchInsert(List<PaymentOrderItem> records);

    PaymentOrderItem selectByPrimaryKey(Integer itemId);

    List<PaymentOrderItem> selectAll();

    int updateByPrimaryKey(PaymentOrderItem record);
}