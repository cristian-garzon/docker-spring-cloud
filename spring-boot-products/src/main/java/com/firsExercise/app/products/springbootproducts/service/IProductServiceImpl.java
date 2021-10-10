package com.firsExercise.app.products.springbootproducts.service;

import com.firsExercise.app.products.springbootproducts.repository.productRepo;
import com.springdocker.cammons.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IProductServiceImpl implements IproductService {

    @Autowired
    private productRepo productRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}
