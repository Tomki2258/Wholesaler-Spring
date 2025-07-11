package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.Jdbc.ProductsJdbc;
import com.tamus.Wholesaler.Repository.RepositoryService;
import com.tamus.Wholesaler.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    private ProductsJdbc productsJdbc = ProductsJdbc.getInstance();
    private RepositoryService repositoryService = RepositoryService.getInstance();
    private OrdersService ordersService = new OrdersService();
    @PostMapping("/addProduct")
    public void addProduct(@RequestParam String name,
                           @RequestParam String producent,
                           @RequestParam double price){
        Product product = Product.builder()
                .id(productsJdbc.getAll().size() + 1)
                .name(name)
                .producent(producent)
                .price(price)
                .build();
        repositoryService.addProduct(product);
    }
    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestParam int id) {
        repositoryService.deleteProduct(id);
    }
    @PostMapping("/deleteProductByName")
    public void deleteProduct(@RequestParam String name) {
        repositoryService.deleteByNameProduct(name);
    }
    @GetMapping("/size")
    public int getSize(){
        return repositoryService.getSize();
    }
}
