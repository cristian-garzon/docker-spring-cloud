package com.firsExercise.app.products.springbootproducts.service.implement;

import com.firsExercise.app.products.springbootproducts.entity.product;
import com.firsExercise.app.products.springbootproducts.repository.productRepo;
import com.firsExercise.app.products.springbootproducts.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements IproductService {

    @Autowired
    private productRepo product;


    @Override
    @Transactional(readOnly = true)
    public List<product> findAll() {
        return product.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<product> findById(Long id) {
        return product.findById(id);
    }
}
