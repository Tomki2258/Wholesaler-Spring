package com.tamus.Wholesaler.Controllers;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.RepositoryService;
import com.tamus.Wholesaler.ShoppingCart.IShoppingCart;
import com.tamus.Wholesaler.ShoppingCart.ShoppingCart;
import com.tamus.Wholesaler.services.UserDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController implements IShoppingCart {
    private RepositoryService repositoryService = RepositoryService.getInstance();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @PostMapping("/add")
    @Override
    public void addProduct(@RequestParam int index) {
        shoppingCart.addProduct(index);
    }

    @PostMapping("/remove")
    @Override
    public void removeProduct(@RequestParam int index) {
        shoppingCart.removeProduct(index);
    }

    @GetMapping("/adds")
    @Override
    public void addProducts(@RequestParam int index,@RequestParam int amount) {
        shoppingCart.addProducts(index,amount);
    }
    @PostMapping("/removes")
    @Override
    public void removeProducts(@RequestParam int  index,@RequestParam int amount) {
        shoppingCart.removeProducts(index, amount);
    }

    @GetMapping("/summary")
    @Override
    public double summary() {
        return shoppingCart.summary();
    }

    @Override
    public void setOrder(int userId, double orderSum) {

    }
    @GetMapping("/getCartProducts")
    @Override
    public List<Product> getCartProducts() {
        return shoppingCart.getCartProducts();
    }

    @GetMapping("/setOrder")
    public void setOrder() {
        shoppingCart.setOrder(summary());
    }
}
