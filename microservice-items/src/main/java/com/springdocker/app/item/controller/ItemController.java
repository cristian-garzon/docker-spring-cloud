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
import java.util.concurrent.CompletableFuture;

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
                error -> alternativeMethod(id, size,error)));
    }

    public CompletableFuture<Item> alternativeMethod(Long id, Integer size, Throwable error){
        logger.info(error.getMessage());
        Item item = new Item();
        Product product = new Product();
        item.setSize(size);
        product.setCreateAt(new Date());
        product.setName("product default");
        product.setPrice(0);
        item.setProduct(product);
        return CompletableFuture.supplyAsync(() -> item);
    }

    @CircuitBreaker(name = "items",fallbackMethod = "alternativeMethod")
    @TimeLimiter(name = "items")
    @GetMapping("/find2/{id}/size/{size}")
    public CompletableFuture<Item> find2(@PathVariable Long id, @PathVariable Integer size){
        return CompletableFuture.supplyAsync(() -> itemService.find(id,size));

    }
}
