package com.tamus.Wholesaler.Entities;

import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String producent;
    @Getter
    private double price;
}