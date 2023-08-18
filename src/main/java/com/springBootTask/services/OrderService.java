package com.springBootTask.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface OrderService {

    public Order createOrderById(Set<OrderItem> orderItem,  Long id);
    public List<Order> getAllOrders();
    public Order getOrderById(Long orderId);
    public Order updateOrder(Long orderId, Order orderDetail);
    public Order deleteOrderById(Long orderId);
    public Order createOrder(Order order);

   // Set <Order> getAllOrdersWithItems();
}

