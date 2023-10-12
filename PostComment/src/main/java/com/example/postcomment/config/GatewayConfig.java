package com.example.postcomment.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("postcomment-service", r -> r.path("/postcomment/**")
                        .uri("http://postcomment-service:POSTCOMMENT-SERVICE-PORT"))
                .build();
    }
}