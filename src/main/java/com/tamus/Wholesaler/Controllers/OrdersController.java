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
    @PostMapping("/calcelOrder")
    public void cancelOrder(@RequestParam int id) {
        ordersService.cancelOrder(id);
    }
    @PostMapping("/approveOrder")
    public void approveOrder(@RequestParam int id) {
        ordersService.approveOrder(id);
    }
}
