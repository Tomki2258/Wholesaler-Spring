package com.tamus.Wholesaler.Repository.Jdbc;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.IRepository;
import com.tamus.Wholesaler.db.JdbcConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsJdbc implements IRepository {

    private static ProductsJdbc instance;

    public static ProductsJdbc getInstance(){
        if(instance == null){
            instance = new ProductsJdbc();
        }
        return instance;
    }

    public int getSize() {
        return getAll().size();
    }
    @Override
    public Optional<Product> getByIndex(int index) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public void setProductsList(List<Product> productList) {

    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();

        String sql = "select * from products";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String producent = rs.getString(3);
                double price = rs.getDouble(4);
                Product product = Product.builder()
                                .id(id).name(name)
                                .producent(producent)
                            .price(price)
                                .build();
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading products", e);
        }
        return productList;
    }

    @Override
    public boolean isAvailable(int index) {
        return false;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, producent, price) VALUES (?, ?, ?)";

        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getProducent());
            stmt.setDouble(3, product.getPrice());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas dodawania produktu", e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas usuwania produktu po id", e);
        }
    }

    @Override
    public void deleteByNameProduct(String name) {
        String sql = "DELETE FROM products WHERE name = ?";
        try (Connection connection = JdbcConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas usuwania produktu po nazwie", e);
        }
    }
}
