package com.firsExercise.app.products.springbootproducts.service.implement;

import com.firsExercise.app.products.springbootproducts.entity.item;
import com.firsExercise.app.products.springbootproducts.repository.productRepo;
import com.firsExercise.app.products.springbootproducts.service.IitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class itemServiceImpl implements IitemService {

    @Autowired
    private productRepo repo;


    @Override
    public item list(long id, double quantity) {
        return new item(repo.findAllById(id), quantity);
    }
}
