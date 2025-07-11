package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Order;
import com.tamus.Wholesaler.Repository.OrdersRepository;
import com.tamus.Wholesaler.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ordersService")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService = OrdersService.getInstance();
    @PostMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return ordersService.getAll();
    }
    @PostMapping("/cancelOrder")
    public void cancelOrder(@RequestParam int id) {
        ordersService.cancelOrder(id);
    }
    @PostMapping("/approveOrder")
    public void approveOrder(@RequestParam int id) {
        ordersService.approveOrder(id);
    }
    @PostMapping("/pendingOrders")
    public List<Order> pendingOrders() {
        return ordersService.getAll().stream()
                .filter(order -> order.getStatus().equals("PENDING"))
                .toList();
    }
    @PostMapping("/approvedOrders")
    public List<Order> approvedOrders() {
        return ordersService.getAll().stream()
                .filter(order -> order.getStatus().equals("APPROVED"))
                .toList();
    }
    @PostMapping("/canceledOrders")
    public List<Order> canceledOrders() {
        return ordersService.getAll().stream()
                .filter(order -> order.getStatus().equals("CANCELED"))
                .toList();
    }
    @PostMapping("/inProgressOrders")
    public List<Order> inProgressOrders() {
        return ordersService.getAll().stream()
                .filter(order -> order.getStatus().equals("IN_PROGRESS"))
                .toList();
    }
    @PostMapping("/bringBackOrder")
    public void bringBackOrder(@RequestParam int id) {
        ordersService.approveOrder(id);
    }
}
