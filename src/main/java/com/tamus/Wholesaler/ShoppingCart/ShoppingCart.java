package com.tamus.Wholesaler.ShoppingCart;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.CartRepository;
import com.tamus.Wholesaler.Repository.RepositoryService;

import java.util.ArrayList;
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
    public double summary() {
        return productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public void setOrder(int userId, double orderSum) {
            cartRepository.setOrder(userId,orderSum);
    }
}
