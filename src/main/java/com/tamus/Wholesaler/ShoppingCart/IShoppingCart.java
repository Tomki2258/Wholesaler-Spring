package com.tamus.Wholesaler.ShoppingCart;

import com.tamus.Wholesaler.Entities.Order;
import com.tamus.Wholesaler.Entities.Product;

import java.util.List;

public interface IShoppingCart {
    void addProduct(int index);
    void removeProduct(int index);
    void addProducts(int index,int amount);
    void removeProducts(int index, int amount);
    double summary();
    void setOrder(int userId,double orderSum);
    List<Product> getCartProducts();
}
