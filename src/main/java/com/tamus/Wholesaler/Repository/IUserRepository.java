package com.tamus.Wholesaler.Repository;

import com.tamus.Wholesaler.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getAll();
    Optional<User> getByIndex(int index);
    Optional<User> findByLogin(String login);
}
