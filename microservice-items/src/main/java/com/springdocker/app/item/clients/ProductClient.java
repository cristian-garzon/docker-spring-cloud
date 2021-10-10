package com.springdocker.app.item.clients;

import com.springdocker.cammons.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-product")
public interface ProductClient {

    @GetMapping("/list")
    public List<Product> list();

    @GetMapping("/find/{id}")
    public Product find(@PathVariable Long id);

    @PostMapping("/save")
    public Product save(@RequestBody Product product);

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id);


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id);
}
