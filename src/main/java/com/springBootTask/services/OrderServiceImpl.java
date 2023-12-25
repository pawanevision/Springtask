package com.springBootTask.services;


import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;
import com.springBootTask.exception.DataNotFoundException;
import com.springBootTask.repository.OrderItemRepository;
import com.springBootTask.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;


    @Autowired
    private OrderItemRepository orderItemRepository;



    public Order createOrderById(Set<OrderItem> orderItem, Long id) {
        Order order= orderRepository.findByOrderId(id);
        order.setOrderItemList(orderItem);
        orderRepository.save(order);
        return  order;


    }
//    public Set<Order> getAllOrdersWithItems() {
//        return orderRepository.findAllWithOrderItems();
//    }
    public List<Order> getAllOrders()  {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

    public Order getOrderById(Long orderId) {
        Order order = null;
        Optional<Order> dataList = orderRepository.findById(orderId);
        if(orderId.equals(dataList.get().getOrderId())) {
            order =  orderRepository.findById(orderId).orElse(null);
        }
        else{
            throw new NoSuchElementException();
        }

        return order;
    }

    public Order updateOrder(Long orderId, Order order) {
        Optional<Order> orderList = orderRepository.findById(orderId);

        Order orderDetail1;
        if (orderId.equals(orderList.get().getOrderId())) {
            orderDetail1 = orderRepository.save(order);
        } else {
            throw new NoSuchElementException();
        }
        return orderDetail1;
    }
    public Order deleteOrderById(Long orderId) {
        Optional<Order> orderList=orderRepository.findById(orderId);
        if(orderId.equals(orderList.get().getOrderId())) {
            orderRepository.deleteById(orderId);
System.out.println("heljo");
        }
        else{
            throw new NoSuchElementException();
      
        return orderList.get();
    }

    @Override
    public Order createOrder(Order order) {
        List<Order> storedList = orderRepository.findAll();
        if(storedList.isEmpty()) { orderRepository.save(order); }
        else{
            for(Order order1 : storedList) {
                if (order.getOrderPersonName().equals(order.getOrderPersonName())) {
                    throw new DataNotFoundException();
                }
                else {
                    orderRepository.save(order);
                }
            }
        }
        return order;
    }



}



