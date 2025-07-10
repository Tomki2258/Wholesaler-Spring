package com.tamus.Wholesaler.Repository;

import com.tamus.Wholesaler.ShoppingCart.IShoppingCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import com.tamus.Wholesaler.db.JdbcConnectionManager;
import com.tamus.Wholesaler.services.UserDataService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
public class CartRepository implements IShoppingCart {
    @Override
    public void addProduct(int index) {

    }

    @Override
    public void removeProduct(int index) {

    }

    @Override
    public void addProducts(int index, int amount) {

    }

    @Override
    public void removeProducts(int index, int amount) {

    }

    @Override
    public double summary() {
        return 0;
    }

    @Override
    public void setOrder(int userId, double orderSum) {
        String sql = "INSERT INTO orders (user_id, order_sum, startedat, paidat) VALUES (?, ?, ?, ?)";

        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

            stmt.setInt(1, userId);
            stmt.setDouble(2, orderSum);
            stmt.setTimestamp(3, currentTimestamp);
            stmt.setNull(4, java.sql.Types.TIMESTAMP);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas dodawania zamówienia", e);
        }
    }
    public void setOrder(double orderSum) {
        String sql = "INSERT INTO orders (user_id, order_sum, startedat, paidat) VALUES (?, ?, ?, ?)";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = UserDataService.getInstance().getLogin();
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

            stmt.setString(1, username);
            stmt.setDouble(2, orderSum);
            stmt.setTimestamp(3, currentTimestamp);
            stmt.setNull(4, java.sql.Types.TIMESTAMP);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas dodawania zamówienia", e);
        }
    }
}
