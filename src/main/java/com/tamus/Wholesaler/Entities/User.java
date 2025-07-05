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
    public User(int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public void Describe(){
        System.out.println("cos");
    }
}
