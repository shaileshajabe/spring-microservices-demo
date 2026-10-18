package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Table(name="orders")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;       // ID of user who placed order
    private Long productId;    // ID of product ordered
    private int quantity;

    private LocalDateTime orderDate;

    private String status;

}