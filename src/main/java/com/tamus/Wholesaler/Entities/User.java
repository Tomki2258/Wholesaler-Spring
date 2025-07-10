package com.tamus.Wholesaler.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    private int id;
    @Getter
    private String login;
    @Getter
    private String password;
    @Getter
    private String role;

    public void Describe(){
        System.out.println("cos");
    }
}
