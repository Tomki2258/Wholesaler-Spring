package com.tamus.Wholesaler.Repository;

import com.tamus.Wholesaler.Entities.Order;
import com.tamus.Wholesaler.db.JdbcConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepository implements IOrders{
    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();

        String sql = "select * from orders";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                double order_sum = rs.getDouble(3);
                LocalDateTime startedat = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime paidat = rs.getTimestamp(5) != null ? rs.getTimestamp(5).toLocalDateTime() : null;
                String status = rs.getString(6);

                Order order = Order.builder()
                        .id(id)
                        .userName(user_id)
                        .order_sum(order_sum)
                        .startedat(startedat)
                        .paidat(paidat)
                        .status(status)
                        .build();

                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading products", e);
        }
        return orderList;
    }

    @Override
    public void approveById(int id) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "IN_PROGRESS");
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating order status", e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "CANCELED");
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error canceling order", e);
        }
    }

    @Override
    public void bringBackById(int id) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "IN_PROGRESS");
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error canceling order", e);
        }
    }
}
