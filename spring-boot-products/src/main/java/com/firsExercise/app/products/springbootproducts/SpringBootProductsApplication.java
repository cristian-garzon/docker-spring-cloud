package com.firsExercise.app.products.springbootproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductsApplication.class, args);
	}

}
