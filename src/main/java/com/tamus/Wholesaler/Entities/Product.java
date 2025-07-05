package com.tamus.Wholesaler.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "products")
@Builder
public class Product {
    @Id
    private int id;
    @Getter
    private String name;
    @Getter
    private String producent;
    @Getter
    private double price;
    public Product(int id,String name,String producent,double price){
        this.id = id;
        this.name = name;
        this.producent = producent;
        this.price = price;
    }

    public void Describe(){
        System.out.println("cos");
    }
}
