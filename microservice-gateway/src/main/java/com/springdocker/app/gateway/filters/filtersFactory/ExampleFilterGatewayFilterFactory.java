package com.springdocker.app.gateway.filters.filtersFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ExampleFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<ExampleFilterGatewayFilterFactory.Configuration> {

    public ExampleFilterGatewayFilterFactory() {
        super(Configuration.class);
    }

    Logger logger = LoggerFactory.getLogger(ExampleFilterGatewayFilterFactory.class);

    @Override
    public GatewayFilter apply(Configuration config) {
        return new OrderedGatewayFilter((exchange, chain) -> {
            logger.info("pre gateway filter executing"+config.message);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Optional.ofNullable(config.coockieValue).ifPresent(coockie -> {
                   exchange.getResponse().addCookie(ResponseCookie.from(config.coockiename, coockie).build());
                });
                logger.info("post gateway filter executing" + config.message);
            }));
        },2);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("message","coockiename","coockieValue");
    }

    public static class Configuration {
        private String message;
        private String coockieValue;
        private String coockiename;

        public void setMessage(String message) {
            this.message = message;
        }

        public void setCoockieValue(String coockieValue) {
            this.coockieValue = coockieValue;
        }

        public void setCoockiename(String coockiename) {
            this.coockiename = coockiename;
        }

        public String getMessage() {
            return message;
        }

        public String getCoockieValue() {
            return coockieValue;
        }

        public String getCoockiename() {
            return coockiename;
        }
    }
}
