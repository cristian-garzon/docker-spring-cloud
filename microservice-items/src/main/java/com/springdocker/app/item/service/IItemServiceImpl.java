package com.springdocker.app.item.service;

import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IItemServiceImpl implements IItemService{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Item> list() {
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/list",Product[].class));
        return products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item find(Long id, Integer size) {
        Map<String, String> pathvariables = new HashMap();
        pathvariables.put("id", id.toString());
        Product product = restTemplate.getForObject("http://localhost:8001/find/{id}",Product.class, pathvariables);
        return new Item(product, size);
    }
}
