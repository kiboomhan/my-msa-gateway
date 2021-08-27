package com.example.msagateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/app01/**")
                        .filters(f -> f.addRequestHeader("app01-gate-in", "app01-gate-gogo")
                                .addResponseHeader("app01-gate-out", "app01-gate-byebye"))
                        .uri("http://localhost:8081"))
                .route(r -> r.path("/app02/**")
                        .filters(f -> f.addRequestHeader("app02-gate-in", "app02-gate-gogo")
                                .addResponseHeader("app02-gate-out", "app02-gate-byebye"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
