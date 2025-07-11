package com.tamus.Wholesaler.services;

import com.tamus.Wholesaler.Entities.Order;
import com.tamus.Wholesaler.Repository.OrdersRepository;

import java.util.List;

public class OrdersService {
    private static OrdersService instance;
    public static OrdersService getInstance() {
        if (instance == null) {
            instance = new OrdersService();
        }
        return instance;
    }
    private OrdersRepository ordersRepository = new OrdersRepository();
    public List<Order> getAll(){
        return ordersRepository.getAll();
    }

    public void cancelOrder(int id) {
        ordersRepository.deleteById(id);
    }

    public void approveOrder(int id) {
        ordersRepository.approveById(id);
    }
    public void bringBackOrder(int id) {
        ordersRepository.bringBackById(id);
    }
}
