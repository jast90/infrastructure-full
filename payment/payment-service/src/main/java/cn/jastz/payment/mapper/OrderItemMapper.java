package cn.jastz.payment.mapper;

import cn.jastz.payment.entity.OrderItem;
import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(Integer itemId);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}