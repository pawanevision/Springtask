package com.springBootTask.repository;


import com.springBootTask.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Set;

@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Long> {
   public Order findByOrderId(Long id);


}
