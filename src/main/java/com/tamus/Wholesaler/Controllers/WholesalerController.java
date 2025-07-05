package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.Jdbc.ProductsJdbcRepository;
import com.tamus.Wholesaler.Repository.RepositoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WholesalerController {
    private ProductsJdbcRepository productsJdbcRepository = new ProductsJdbcRepository();
    private RepositoryService repositoryService = new RepositoryService();
    public WholesalerController(){
        repositoryService.setProductsList(
                productsJdbcRepository.getAll() 
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
}
