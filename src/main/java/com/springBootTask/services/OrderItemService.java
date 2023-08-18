package com.springBootTask.services;

import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    public OrderItem createOrderItem(OrderItem orderItem);
    public List<OrderItem> getAllOrderItems();
    public OrderItem getOrderItemById(Long orderId);
    public OrderItem updateOrderItem(Long id, OrderItem orderItem);
    public OrderItem deleteOrderItem(Long id);
}
