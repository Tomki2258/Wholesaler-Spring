package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.Jdbc.ProductsJdbc;
import com.tamus.Wholesaler.Repository.RepositoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wholesaler")
public class WholesalerController {
    private ProductsJdbc productsJdbc = new ProductsJdbc();
    private RepositoryService repositoryService = RepositoryService.getInstance();
    public WholesalerController(){
        repositoryService.setProductsList(
                productsJdbc.getAll()
        );
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/getAll")
    public List<Product> getAll(){
        return repositoryService.getAll();
    }
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
    @GetMapping("/size")
    public int getSize(){
        return repositoryService.getSize();
    }
}