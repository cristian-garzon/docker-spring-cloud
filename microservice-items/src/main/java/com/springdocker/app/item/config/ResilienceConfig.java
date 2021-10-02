package com.springdocker.app.item.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> configResilience(){
        return factory -> factory.configureDefault(item -> {
            return new Resilience4JConfigBuilder(item).circuitBreakerConfig(CircuitBreakerConfig.custom()
                    .slidingWindowSize(8)
                    .failureRateThreshold(50)
                    .permittedNumberOfCallsInHalfOpenState(5)
                    .waitDurationInOpenState(Duration.ofSeconds(15L))
                    .build())
                    .timeLimiterConfig(TimeLimiterConfig.ofDefaults())
                    .build();
        });
    }
}
