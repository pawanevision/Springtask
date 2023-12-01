package com.springBootTask.controller;




import com.springBootTask.dto.OrderItemDTO;
import com.springBootTask.entity.Order;
import com.springBootTask.entity.OrderItem;
import com.springBootTask.repository.OrderRepository;
import com.springBootTask.services.OrderItemServiceImpl;
import com.springBootTask.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springBootTask.repository.OrderItemRepository;

import java.util.*;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    private final OrderItemServiceImpl orderItemService;

    private final OrderItemRepository orderItemRepository;
    private final OrderService orderService;

    private final OrderRepository orderRepository;


    public OrderItemController(OrderItemServiceImpl orderItemService, OrderItemRepository orderItemRepository, OrderService orderService, OrderRepository orderRepository) {
        this.orderItemService = orderItemService;

        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }


    @GetMapping("/getAll")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }


    @GetMapping("/getId/{orderId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("orderId") Long orderId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderId);
        return optionalOrderItem.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemDTO orderItem) {
        OrderItem newOrderItem = new OrderItem();

        newOrderItem.setItemName(orderItem.getItemName());
        newOrderItem.setItemPrice((long) orderItem.getItemPrice());
        newOrderItem.setQuantity(orderItem.getQuantity());

        Optional<Order> optionalOrder = orderRepository.findById(orderItem.getOrderId());
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            newOrderItem.setOrder(order);

            order.getOrderItemList().add(newOrderItem);
        } else {

            return ResponseEntity.badRequest().build();
        }

        OrderItem createdOrderItem = orderItemService.createOrderItem(newOrderItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
    }


    @PutMapping("/update/{orderId}/{itemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long orderId, @PathVariable Long itemId, @RequestBody OrderItem updatedOrderItem) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findByOrderOrderIdAndItemId(orderId, itemId);

        if (optionalOrderItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        OrderItem existingOrderItem = optionalOrderItem.get();
        existingOrderItem.setItemName(updatedOrderItem.getItemName());
        existingOrderItem.setItemPrice(updatedOrderItem.getItemPrice());
        existingOrderItem.setQuantity(updatedOrderItem.getQuantity());

        OrderItem savedOrderItem = orderItemRepository.save(existingOrderItem);
        return ResponseEntity.ok(savedOrderItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        if (!orderItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        orderItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

