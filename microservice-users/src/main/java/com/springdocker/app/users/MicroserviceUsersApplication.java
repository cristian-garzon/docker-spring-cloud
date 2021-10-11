package com.springdocker.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUsersApplication.class, args);
    }

}
