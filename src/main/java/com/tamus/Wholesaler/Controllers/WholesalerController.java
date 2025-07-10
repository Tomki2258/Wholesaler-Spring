package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.Jdbc.ProductsJdbc;
import com.tamus.Wholesaler.Repository.RepositoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wholesaler")
public class WholesalerController {
    private ProductsJdbc productsJdbc = ProductsJdbc.getInstance();
    private RepositoryService repositoryService = RepositoryService.getInstance();
    public WholesalerController(){
        repositoryService.setProductsList(
                productsJdbc.getAll()
        );
    }
    @GetMapping("/getAll")
    public List<Product> getAll(){
        return repositoryService.getAll();
    }
}