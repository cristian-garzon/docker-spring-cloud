package com.firsExercise.app.products.springbootproducts.repository;

import com.firsExercise.app.products.springbootproducts.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepo extends JpaRepository<product, Long> {

    product findAllById(long id);
}

