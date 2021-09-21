package com.springdocker.app.item.controller;

import com.springdocker.app.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(itemService.list());
    }

    @GetMapping("/find/{id}/size/{size}")
    public ResponseEntity<?> find(@PathVariable Long id, @PathVariable Integer size){
        if (itemService.find(id,size) == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(itemService.find(id,size));
    }
}
