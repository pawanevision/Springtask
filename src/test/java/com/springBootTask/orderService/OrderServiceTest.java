package com.springBootTask.orderService;

import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;
import com.springBootTask.repository.OrderRepository;
import com.springBootTask.services.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        order.setOrderId(1);
        order.setOrderPersonName("pawan");

        when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        when(orderRepository.save(any())).thenReturn(order);

        Order result = orderService.createOrder(order);

        assertNotNull(result);
        assertEquals(order.getOrderId(), result.getOrderId());
        assertEquals(order.getOrderPersonName(), result.getOrderPersonName());

        verify(orderRepository, times(1)).findAll();
        verify(orderRepository, times(1)).save(order);
    }


    @Test
    void testGetAllOrder() {
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order();
        order1.setOrderId(1);
        order1.setOrderPersonName("Pawan");
        orderList.add(order1);

        Order order2 = new Order();
        order2.setOrderId(2);
        order2.setOrderPersonName("Sarthak");
        orderList.add(order2);

        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> result = orderService.getAllOrders();

        assertEquals(2, result.size());
        assertEquals(order1, result.get(0));
        assertEquals(order2, result.get(1));

        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testGetOrderbyId() {
        long orderId = 1;
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderPersonName("Pawan");

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(orderId);

        assertNotNull(result);
        assertEquals(order, result);

        verify(orderRepository, times(2)).findById(orderId);
    }


    @Test
    void testUpdateOrder() {
        long orderId = 1;
        Order existingOrder = new Order();
        existingOrder.setOrderId(orderId);
        existingOrder.setOrderPersonName("Pawan");

        Order updatedOrder = new Order();
        updatedOrder.setOrderId(orderId);
        updatedOrder.setOrderPersonName("Ankit");

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));
        when(orderRepository.save(any())).thenReturn(updatedOrder);

        Order result = orderService.updateOrder(orderId, updatedOrder);

        assertNotNull(result);
        assertEquals(updatedOrder, result);

        verify(orderRepository, times(1)).findById(orderId);
        verify(orderRepository, times(1)).save(updatedOrder);
    }


    @Test
    void testDeleteOrderById() {
        long orderId = 1;
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderPersonName("Pawan");

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Order result = orderService.deleteOrderById(orderId);

        assertNotNull(result);
        assertEquals(order, result);

        verify(orderRepository, times(1)).findById(orderId);
        verify(orderRepository, times(1)).deleteById(orderId);
    }
    @Test
     void testCreateOrderById() {
        Order mockOrder = new Order();
        mockOrder.setOrderId(1L);
        Set<OrderItem> mockOrderItems = new HashSet<>();
        OrderItem mockOrderItem = new OrderItem();
        mockOrderItem.setItemId(1L);
        mockOrderItem.setItemName("pawan");
        mockOrderItems.add(mockOrderItem);

        when(orderRepository.findByOrderId(1L)).thenReturn(mockOrder);
        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);
        Order resultOrder = orderService.createOrderById(mockOrderItems, 1L);
        verify(orderRepository, times(1)).findByOrderId(1L);
        verify(orderRepository, times(1)).save(any(Order.class));

        assertNotNull(resultOrder);
        assertEquals(1L, resultOrder.getOrderId());
        assertEquals(mockOrderItems, resultOrder.getOrderItemList());
    }
}

