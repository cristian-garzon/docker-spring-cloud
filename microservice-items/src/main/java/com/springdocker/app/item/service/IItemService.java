package com.springdocker.app.item.service;

import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;

import java.util.List;

public interface IItemService {

    public List<Item> list();
    public Item find(Long id, Integer size);
    public Product save(Product product);
    public Product update(Product product, Long id);
    public void delete(Long id);
}
