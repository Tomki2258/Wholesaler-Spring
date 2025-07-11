package com.tamus.Wholesaler.Repository;

import com.tamus.Wholesaler.Entities.Order;

import java.util.List;

public interface IOrders {
    List<Order> getAll();

    void approveById(int id);

    void deleteById(int id);
}
