package com.springdocker.app.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity hhtp){
        return  hhtp.authorizeExchange().anyExchange().authenticated().and().csrf().disable().build();
    }
}
