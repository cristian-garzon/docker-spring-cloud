package com.firsExercise.app.products.springbootproducts.restController;

import com.firsExercise.app.products.springbootproducts.entity.item;
import com.firsExercise.app.products.springbootproducts.entity.product;
import com.firsExercise.app.products.springbootproducts.service.IitemService;
import com.firsExercise.app.products.springbootproducts.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class controller {


    @Autowired
    private IproductService productService;

    @Autowired
    private IitemService itemService;
    @GetMapping("/list")
    public List<product> list(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<product> details(@PathVariable long id){
        return productService.findById(id);
    }

    @GetMapping("/list/items/{id}/{quantity}")
    public item listItems(@PathVariable long id, @PathVariable double quantity){
        return itemService.list(id, quantity);
    }
}
