package com.tamus.Wholesaler.services;

import com.tamus.Wholesaler.Entities.Product;
import com.tamus.Wholesaler.Repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryService implements IRepository {
    private static RepositoryService instance = null;
    private List<Product> productList = new ArrayList<Product>();
    public static RepositoryService  getInstance(){
        if(instance == null){
            instance = new RepositoryService();
        }
        return instance;
    }
    @Override
    public Optional<Product> getByIndex(int index) {
        return Optional.of(productList.get(index));
    }
    public int getSize(){
        return productList.size();
    }
    @Override
    public Optional<Product> getByName(String name) {
        return productList.stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    @Override
    public void setProductsList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public boolean isAvailable(int index) {
        return false;
    }
}
