package com.alaeddine.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("TransactionService", r -> r
                        .path("/api/v1/**")
                        .uri("http://bank-transaction-app:8085"))
                .route("BankProfileService", r -> r
                        .path("/api/v2/**")
                        .uri("http://bank-profile-app:8086"))
                .build();
    }
}
