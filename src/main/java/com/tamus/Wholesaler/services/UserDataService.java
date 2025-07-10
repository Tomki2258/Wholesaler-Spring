package com.tamus.Wholesaler.services;

import lombok.Getter;
import lombok.Setter;

public class UserDataService {
    private static UserDataService instance;
    public static UserDataService getInstance() {
        if (instance == null) {
            instance = new UserDataService();
        }
        return instance;
    }

    @Getter
    @Setter
    private String login;
}
