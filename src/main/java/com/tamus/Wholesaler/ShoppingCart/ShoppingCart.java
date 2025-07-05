package com.tamus.Wholesaler.ShoppingCart;

import com.tamus.Wholesaler.Entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements IShoppingCart {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void addProducts(Product product, int amount) {
        for (int i = 0; i < amount; i++) {
            productList.add(product);
        }
    }

    @Override
    public double summary() {
        return productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
