package com.firsExercise.app.products.springbootproducts.controller;

import com.firsExercise.app.products.springbootproducts.service.IproductService;
import com.springdocker.cammons.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private IproductService service;

    @Autowired
    private Environment env;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.findAll().stream().map(product -> {
            product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) throws InterruptedException {
        Product product = service.findById(id);
        if(product == null) throw new IllegalStateException("product not found :c");
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return  ResponseEntity.ok().body(product);
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){
        Product product1Update = service.findById(id);
        if(product == null) return ResponseEntity.notFound().build();
        product1Update.setPrice(product.getPrice());
        product1Update.setName(product.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(service.findById(id) == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
