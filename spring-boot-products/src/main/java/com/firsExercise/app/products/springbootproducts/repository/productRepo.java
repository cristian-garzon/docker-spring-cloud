package com.firsExercise.app.products.springbootproducts.repository;

import com.firsExercise.app.products.springbootproducts.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface productRepo extends JpaRepository<product, Long> {
}

