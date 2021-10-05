package com.springdocker.app.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class globalFiltesr implements GlobalFilter , Ordered {

    private final Logger logger = LoggerFactory.getLogger(globalFiltesr.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("pre filter executing");
        exchange.getRequest().mutate().headers(httpHeaders -> httpHeaders.add("token","12345"));
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("post filter executing");
            Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(data -> {
                exchange.getResponse().getHeaders().add("token", data);
            });
            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "red").build());
        }));
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
