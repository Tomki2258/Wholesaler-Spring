package com.tamus.Wholesaler.Repository.Jdbc;

import com.tamus.Wholesaler.Entities.User;
import com.tamus.Wholesaler.Repository.IUserRepository;
import com.tamus.Wholesaler.db.JdbcConnectionManager;
import org.springframework.security.crypto.bcrypt.BCrypt;

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
                String role = rs.getString(4);
                User product = User.builder()
                        .id(id)
                        .login(login)
                        .password(password)
                        .role(role)
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

    @Override
    public Optional<User> findByLogin(String login) {
        return userList.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (login, password, role) VALUES (?, ?, ?)";

        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            stmt.setString(1, user.getLogin());
            stmt.setString(2, hashed);
            stmt.setString(3, user.getRole());

            stmt.executeUpdate();

            userList = getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas dodawania użytkownika", e);
        }
    }
}
