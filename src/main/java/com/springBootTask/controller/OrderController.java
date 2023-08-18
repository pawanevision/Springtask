package com.springBootTask.controller;



import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;
import com.springBootTask.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/create/{id}")
    public ResponseEntity<Order> createOrderItem(@RequestBody Set<OrderItem> orderItem,@PathVariable Long id) {
        Order order= new Order();
        order= orderService.createOrderById(orderItem,id);
        return new  ResponseEntity<>(order, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        order = orderService.createOrder(order);
        return ResponseEntity.of(Optional.of(order));
    }
//    @GetMapping("/getAll")
//    public Set<Order> getAllOrdersWithItems() {
//        return orderService.getAllOrdersWithItems();
//    }


    @GetMapping(" ")
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.of(Optional.of(orderList));
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderbyId(@PathVariable("orderId") Long orderId){
        Order orderDetail = orderService.getOrderById(orderId);
        return ResponseEntity.of(Optional.of(orderDetail));
    }

    @PutMapping(value = "/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order orderDetail) {
        orderDetail.setOrderId(orderId);
        return orderService.updateOrder(orderId, orderDetail);
    }

    @DeleteMapping(value = "/{orderid}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable Long orderid) {
        Order orderData = orderService.deleteOrderById(orderid);
        return ResponseEntity.ok(orderData);
    }





}
