package com.springdocker.app.item.controller;

import com.springdocker.app.item.entity.Item;
import com.springdocker.app.item.entity.Product;
import com.springdocker.app.item.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class ItemController {

    @Autowired
    private Environment environment;

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

    @GetMapping("/show-port")
    public ResponseEntity<?> shoConfig(){
        Map<String,String> config = new HashMap<>();
        config.put("port", environment.getProperty("server.port"));
        if (environment.getActiveProfiles().length > 0 && environment.getActiveProfiles()[0].equals("dev")){
            config.put("autor",environment.getProperty("aplication.autor"));
            config.put("email",environment.getProperty("aplication.email"));
        }
        return ResponseEntity.ok().body(config);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.ok().body(itemService.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.update(product,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(itemService.find(id,0) == null) return ResponseEntity.notFound().build();
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
