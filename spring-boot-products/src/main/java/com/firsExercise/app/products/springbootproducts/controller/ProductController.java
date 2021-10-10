package com.firsExercise.app.products.springbootproducts.controller;

import com.firsExercise.app.products.springbootproducts.entity.product;
import com.firsExercise.app.products.springbootproducts.service.IproductService;
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
        product product = service.findById(id);
        if(product == null) throw new IllegalStateException("product not found :c");
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return  ResponseEntity.ok().body(product);
    }
    @PostMapping("/save")
    public ResponseEntity<product> save(@RequestBody product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<product> update(@RequestBody product product, @PathVariable Long id){
        product product1Update = service.findById(id);
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
