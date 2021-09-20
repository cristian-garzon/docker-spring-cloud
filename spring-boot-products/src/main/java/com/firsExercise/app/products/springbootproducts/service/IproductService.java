package com.firsExercise.app.products.springbootproducts.service;

import java.util.List;
import java.util.Optional;

import com.firsExercise.app.products.springbootproducts.entity.product;
import org.springframework.transaction.annotation.Transactional;

public interface IproductService {
    public List<product> findAll();
    public Optional<product> findById(Long id);
}
