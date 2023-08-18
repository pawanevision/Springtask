package com.springBootTask.services;

import com.springBootTask.entity.OrderItem;
import com.springBootTask.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long orderId) {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem deleteOrderItem(Long id) {
        return null;
    }

}
