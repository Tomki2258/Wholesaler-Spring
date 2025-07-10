package com.tamus.Wholesaler.Repository;

import com.tamus.Wholesaler.Entities.User;
import com.tamus.Wholesaler.Repository.Jdbc.UserJdbc;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsersService implements IUserRepository{
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
    public Optional<User> findByLogin(String login) {
        return userJdbc.findByLogin(login);
    }

    @Override
    public void addUser(User user) {
        userJdbc.addUser(user);
    }
}
