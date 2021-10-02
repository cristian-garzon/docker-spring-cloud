package com.firsExercise.app.products.springbootproducts.service;

import java.util.List;

import com.firsExercise.app.products.springbootproducts.entity.product;

public interface IproductService {
    public List<product> findAll();
    public product findById(Long id);
}
