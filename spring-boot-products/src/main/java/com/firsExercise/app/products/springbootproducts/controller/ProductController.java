package com.firsExercise.app.products.springbootproducts.controller;

import com.firsExercise.app.products.springbootproducts.entity.product;
import com.firsExercise.app.products.springbootproducts.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
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
    public ResponseEntity<?> find(@PathVariable Long id){
        product product = service.findById(id);
        if(product == null) throw new RuntimeException("product not found :c");
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return  ResponseEntity.ok().body(product);
    }
}