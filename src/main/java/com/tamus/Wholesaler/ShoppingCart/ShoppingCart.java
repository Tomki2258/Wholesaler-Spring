package com.tamus.Wholesaler.ShoppingCart;

import com.tamus.Wholesaler.Entities.Order;
import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.CartRepository;
import com.tamus.Wholesaler.Repository.RepositoryService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart implements IShoppingCart {
    private List<Product> productList = new ArrayList<>();
    private RepositoryService repositoryService = RepositoryService.getInstance();
    private CartRepository cartRepository = new CartRepository();
    @Override
    public void addProduct(int index) {
        if(repositoryService.getByIndex(index).isPresent()){
            productList.add(
                    repositoryService.getByIndex(index)
                            .get());
        }
    }

    @Override
    public void removeProduct(int index) {
        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            if (product.getId() == index) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void addProducts(int index, int amount) {
        if(repositoryService.getByIndex(index).isEmpty()){
            return;
        }
        Product product = repositoryService.getByIndex(index).get();
        for (int i = 0; i < amount; i++) {
            productList.add(product);
        }
    }

    @Override
    public void removeProducts(int index, int amount) {
        int removed = 0;
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext() && removed < amount) {
            Product product = iterator.next();
            if (product.getId() == index) {
                iterator.remove();
                removed++;
            }
        }
    }

    @Override
    public double summary() {
        return productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public void setOrder(int userId, double orderSum) {
            cartRepository.setOrder(userId,orderSum);
    }

    @Override
    public List<Product> getCartProducts() {
        return productList;
    }

    public void setOrder(double orderSum) {
        cartRepository.setOrder(orderSum);
        productList.clear();
    }
}
