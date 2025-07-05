package com.tamus.Wholesaler.ShoppingCart;

import com.tamus.Wholesaler.Entities.Product;

public interface IShoppingCart {
    void addProduct(Product product);
    void addProducts(Product product,int amount);
    double summary();
}
