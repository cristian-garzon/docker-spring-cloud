package com.firsExercise.app.products.springbootproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.springdocker.cammons.product.entity"})
public class SpringBootProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductsApplication.class, args);
	}

}
