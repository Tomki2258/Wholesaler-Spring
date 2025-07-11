package com.tamus.Wholesaler.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @Getter
    @Column(name = "id")
    private int id;
    @Getter
    @Column(name = "user_id")
    private String userName;
    @Getter
    @Column(name = "order_sum")
    private double order_sum;
    @Getter
    @Column(name = "startedat")
    private LocalDateTime startedat;
    @Getter
    @Column(name = "paidat")
    private LocalDateTime paidat;
    @Getter
    @Column(name = "status")
    private String status;
}
