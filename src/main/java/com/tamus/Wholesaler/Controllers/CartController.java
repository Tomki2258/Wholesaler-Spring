package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Repository.RepositoryService;
import com.tamus.Wholesaler.ShoppingCart.IShoppingCart;
import com.tamus.Wholesaler.ShoppingCart.ShoppingCart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController implements IShoppingCart {
    private RepositoryService repositoryService = RepositoryService.getInstance();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @GetMapping("/add")
    @Override
    public void addProduct(@RequestParam int index) {
        shoppingCart.addProduct(index);
    }
    @GetMapping("/adds")
    @Override
    public void addProducts(@RequestParam int index,@RequestParam int amount) {
        shoppingCart.addProducts(index,amount);
    }

    @GetMapping("/summary")
    @Override
    public double summary() {
        return shoppingCart.summary();
    }

    @Override
    public void setOrder(int userId, double orderSum) {

    }
    @GetMapping("/setOrder")
    public void setOrder() {
        shoppingCart.setOrder(1,summary());
    }
}
