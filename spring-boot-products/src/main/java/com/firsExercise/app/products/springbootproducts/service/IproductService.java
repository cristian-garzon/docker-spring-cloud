package com.firsExercise.app.products.springbootproducts.service;

import java.util.List;

import com.springdocker.cammons.product.entity.Product;

public interface IproductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public Product save(Product product);
    public void delete(Long id);
}
