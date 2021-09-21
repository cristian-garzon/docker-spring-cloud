package com.springdocker.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("ProductClient")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
