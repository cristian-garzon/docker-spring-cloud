package com.firsExercise.app.products.springbootproducts.controller;

import com.firsExercise.app.products.springbootproducts.entity.product;
import com.firsExercise.app.products.springbootproducts.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private IproductService service;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        product product = service.findById(id);
        if(product == null) return ResponseEntity.noContent().build();
        return  ResponseEntity.ok().body(product);
    }
}
