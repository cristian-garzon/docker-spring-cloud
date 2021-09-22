package com.springdocker.app.item.clients;

import com.springdocker.app.item.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-product")
public interface ProductClient {

    @GetMapping("/list")
    public List<Product> list();

    @GetMapping("/find/{id}")
    public Product find(@PathVariable Long id);
}
