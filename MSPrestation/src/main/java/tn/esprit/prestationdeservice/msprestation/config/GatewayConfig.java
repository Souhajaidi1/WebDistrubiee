package tn.esprit.prestationdeservice.msprestation.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("MSPrestation", r -> r.path("/MSPrestation/**")
                        .uri("http://MSPrestation:8031")) // Replace 8080 with the actual port number of your portfolio-service
                .build();
    }
}
