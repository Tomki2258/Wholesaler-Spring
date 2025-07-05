package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.RepositoryService;
import com.tamus.Wholesaler.ShoppingCart.IShoppingCart;
import com.tamus.Wholesaler.ShoppingCart.ShoppingCart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController implements IShoppingCart {
    private RepositoryService repositoryService = RepositoryService.getInstance();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @GetMapping("/add")
    @Override
    public void addProduct(Product product) {
        shoppingCart.addProduct(repositoryService.getByIndex(0).get());
    }

    @Override
    public void addProducts(Product product, int amount) {
        shoppingCart.addProducts(product,amount);
    }

    @GetMapping("/summary")
    @Override
    public double summary() {
        return shoppingCart.summary();
    }
}
