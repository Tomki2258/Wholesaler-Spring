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
    public User(int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }
    public User(int id,String login,String password,String role){
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void Describe(){
        System.out.println("cos");
    }
}
