package com.springBootTask.repository;




import com.springBootTask.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


    Optional<OrderItem> findByOrderOrderIdAndItemId(Long orderId, Long itemId);
}

