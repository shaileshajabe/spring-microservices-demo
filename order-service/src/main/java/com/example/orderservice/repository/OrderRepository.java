
package com.example.orderservice.repository;

import com.example.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

    @Query("SELECT CONCAT('Order-', o.id, ' belongs to user-', o.userId) " +
           "FROM Order o WHERE o.id = :orderId AND o.userId = :userId")
    String getOrdersByUserId(
            @Param("userId") Long userId,
            @Param("orderId") Long orderId
    );
}