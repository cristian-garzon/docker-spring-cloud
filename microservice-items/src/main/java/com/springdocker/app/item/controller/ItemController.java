package com.springdocker.app.item.controller;

import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;
import com.springdocker.app.item.service.IItemService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.jar.JarOutputStream;

@RestController
public class ItemController {

    private final Logger logger= LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private IItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(itemService.list());
    }

    @GetMapping("/find/{id}/size/{size}")
    public ResponseEntity<?> find(@PathVariable Long id, @PathVariable Integer size){
        return ResponseEntity.ok().body(itemService.find(id,size));
    }

    @GetMapping("/alternative")
    public ResponseEntity<?> alternativeMethod (){
        System.out.println("debug");
        Item item = new Item();
        Product product = new Product();
        item.setSize(0);
        product.setCreateAt(new Date());
        product.setName("product default");
        product.setPrice(0);
        item.setProduct(product);
        return  ResponseEntity.ok().body(item);
    }

}
