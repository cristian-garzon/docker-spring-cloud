package com.springdocker.app.item.controller;

import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;
import com.springdocker.app.item.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
        return ResponseEntity.ok().body(circuitBreakerFactory.create("item").run(() -> itemService.find(id,size),
                error -> alternativeMethod(id, size,error).getBody()));
    }

    public ResponseEntity<?> alternativeMethod(Long id, Integer size, Throwable error){
        logger.info(error.getMessage());
        Item item = new Item();
        Product product = new Product();
        item.setSize(size);
        product.setCreateAt(new Date());
        product.setName("product default");
        product.setPrice(0);
        item.setProduct(product);
        return ResponseEntity.ok().body(item);
    }

}
