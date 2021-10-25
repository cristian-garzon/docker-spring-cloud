package com.springdocker.app.gateway.security;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        return Mono.justOrEmpty(serverWebExchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
        .filter(auth -> auth.startsWith("Bearer ")).
        switchIfEmpty(webFilterChain.filter(serverWebExchange).then(Mono.empty()))
        .map(token -> token.replace("Bearer ", "")).
        flatMap(token -> authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(null, token))).
        flatMap(authenticationMono -> webFilterChain.
        filter(serverWebExchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(authenticationMono)));
    }
}
