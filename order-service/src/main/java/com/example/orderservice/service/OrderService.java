package com.example.orderservice.service;

import com.example.orderservice.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

   // String getOrdersByUserId(Long userId,Long orderId);

    Order createOrder(Order order);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

   String getOrderWithUserDone(Long orderId,Long userId);
}














