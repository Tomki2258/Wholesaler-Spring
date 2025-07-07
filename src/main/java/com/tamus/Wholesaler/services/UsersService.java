package com.tamus.Wholesaler.services;

import com.tamus.Wholesaler.Entities.User;
import com.tamus.Wholesaler.Repository.IUserRepository;
import com.tamus.Wholesaler.Repository.Jdbc.UserJdbc;

import java.util.List;
import java.util.Optional;

public class UsersService implements IUserRepository {
    private UserJdbc userJdbc = new UserJdbc();
    @Override
    public List<User> getAll() {
        return userJdbc.getAll();
    }

    @Override
    public Optional<User> getByIndex(int index) {
        return userJdbc.getByIndex(index);
    }

    @Override
    public User findByLogin(String login) {
        return userJdbc.findByLogin(login);
    }
}
