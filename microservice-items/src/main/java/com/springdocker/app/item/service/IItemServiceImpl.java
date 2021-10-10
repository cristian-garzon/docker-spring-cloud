package com.springdocker.app.item.service;

import com.springdocker.app.item.clients.ProductClient;
import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IItemServiceImpl implements IItemService{


    @Autowired
    private ProductClient productClient;


    @Override
    public List<Item> list() {
        return productClient.list().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item find(Long id, Integer size) {
        return new Item(productClient.find(id), size);
    }

    @Override
    public Product save(Product product) {
        return productClient.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        return productClient.update(product,id);
    }

    @Override
    public void delete(Long id) {
        productClient.delete(id);
    }
}
