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

}
