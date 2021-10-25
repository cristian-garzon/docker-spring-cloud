package com.springdocker.app.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity hhtp){
        return  hhtp.authorizeExchange().pathMatchers("/api/Oauth/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/Product/list",
                        "/api/Item/list", "/api/User/user","/api/Product/find/{id}",
                        "/api/Item/find/{id}").permitAll().
                pathMatchers(HttpMethod.GET, "/api/User/user/{id}").hasAnyRole("ADMIN", "MOD").
                pathMatchers("/api/Product/**", "/api/Item/**", "/api/User/user/**").hasRole("ADMIN")
                .anyExchange().authenticated().and().
                addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION).csrf().disable().build();
    }
}
