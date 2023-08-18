package com.springBootTask.orderController;

import com.springBootTask.controller.OrderController;
import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;
import com.springBootTask.repository.OrderItemRepository;
import com.springBootTask.repository.OrderRepository;
import com.springBootTask.services.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;
    @Test
    public void testCreateOrder(){
        Order o = new Order();
        o.setOrderType("Cloth");
        o.setOrderPersonName("Pawan");
        o.setOrderDestinationPlace("Indore");
        o.setOrderSourcePlace("Chhatarpur");
        int OrderItem = 0;
        Set<OrderItem> itemList= new HashSet<>(OrderItem);
        o.setOrderItemList(itemList);
        Mockito.when(orderService.createOrder(o)).thenReturn(o);
        ResponseEntity<Order> responseEntity = orderController.createOrder(o);
        Assert.notNull(responseEntity,"Not null");

    }
  @Test
    public void testGetAllOrder(){
        List<Order> orders= new ArrayList<>();
        List<Order> orders1= new ArrayList<>();
        Order order= new Order();
        order.setOrderType("Machine");
        order.setOrderPersonName("Sarthak");
        order.setOrderDestinationPlace("Delhi");
        order.setOrderSourcePlace("Bhopal");
      int OrderItem = 0;
      Set<OrderItem> itemList= new HashSet<>(OrderItem);
        order.setOrderItemList(itemList);
        orders1.add(order);
        Mockito.when(orderService.getAllOrders()).thenReturn(orders1);
        ResponseEntity<List<Order>> responseEntity= orderController.getAllOrder();
        Assert.notNull(responseEntity,"Not null");
    }
    @Test
    public void testGetOrderbyId(){
        Order order = new Order();
        order.setOrderId(1);
        Long orderId = order.getOrderId();
        Mockito.when(orderService.getOrderById(orderId)).thenReturn(order);
        ResponseEntity<Order> responseEntity = orderController.getOrderbyId(orderId);
        Assert.notNull(responseEntity,"Not null");
    }
   @Test
    public void testDeleteOrderById(){
        Order order= new Order();
        order.setOrderId(2);
        Long orderId = order.getOrderId();
        Mockito.when(orderService.deleteOrderById(orderId)).thenReturn(order);
        ResponseEntity<Order>  responseEntity= orderController.deleteOrderById(orderId);
        Assert.notNull(responseEntity,"Not null");
    }
    @Test
    public void testUpdateOrder(){
        Order order= new Order();
        order.setOrderId(5);
        Long orderId = order.getOrderId();
        Mockito.when(orderService.updateOrder(orderId, order)).thenReturn(order);
        Order responseEntity= orderController.updateOrder(orderId,order);
        Assert.notNull(responseEntity, "Not null");
    }

}
