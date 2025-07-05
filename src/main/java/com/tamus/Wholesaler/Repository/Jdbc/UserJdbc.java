package com.tamus.Wholesaler.Repository.Jdbc;

import com.tamus.Wholesaler.Entities.User;
import com.tamus.Wholesaler.Repository.IUserRepository;
import com.tamus.Wholesaler.db.JdbcConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserJdbc implements IUserRepository {
    private List<User> userList;
    public UserJdbc(){
         userList = getAll();
    }
    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();

        String sql = "select * from users";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String login = rs.getString(2);
                String password = rs.getString(3);
                User product = User.builder()
                        .id(id)
                        .login(login)
                        .password(password)
                        .build();
                userList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading products", e);
        }
        return userList;
    }

    @Override
    public Optional<User> getByIndex(int index) {
        return Optional.empty();
    }
}
