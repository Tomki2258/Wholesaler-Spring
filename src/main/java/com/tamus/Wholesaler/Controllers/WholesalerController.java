package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.Jdbc.ProductsJdbc;
import com.tamus.Wholesaler.services.RepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/size")
    public int getSize(){
        return repositoryService.getSize();
    }
}
