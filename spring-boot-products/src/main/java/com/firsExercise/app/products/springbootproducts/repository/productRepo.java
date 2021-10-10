package com.firsExercise.app.products.springbootproducts.repository;

import com.springdocker.cammons.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface productRepo extends JpaRepository<Product, Long> {
}

