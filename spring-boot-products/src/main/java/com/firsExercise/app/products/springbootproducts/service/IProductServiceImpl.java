package com.firsExercise.app.products.springbootproducts.service;

import com.firsExercise.app.products.springbootproducts.entity.product;
import com.firsExercise.app.products.springbootproducts.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductServiceImpl implements IproductService {

    @Autowired
    private productRepo productRepo;

    @Override
    public List<product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
}
