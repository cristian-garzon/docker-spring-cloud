package com.springdocker.app.item.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;
import com.springdocker.app.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(itemService.list());
    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/find/{id}/size/{size}")
    public ResponseEntity<?> find(@PathVariable Long id, @PathVariable Integer size){
        return ResponseEntity.ok().body(itemService.find(id,size));
    }

    public ResponseEntity<?> alternativeMethod(Long id, Integer size){
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
