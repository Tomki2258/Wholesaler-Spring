package com.tamus.Wholesaler.ShoppingCart;

import com.tamus.Wholesaler.Entities.Product;

public interface IShoppingCart {
    void addProduct(int index);
    void addProducts(int index,int amount);
    double summary();
}
