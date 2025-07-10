package com.tamus.Wholesaler.Repository;

import com.tamus.Wholesaler.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    Optional<Product> getByIndex(int index);
    Optional<Product> getByName(String name);
    void setProductsList(List<Product> productList);
    List<Product> getAll();
    boolean isAvailable(int index);
    void addProduct(Product product);

    void deleteProduct(int id);

    void deleteByNameProduct(String name);
}
