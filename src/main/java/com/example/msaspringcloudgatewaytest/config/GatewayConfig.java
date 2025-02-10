package com.example.msaspringcloudgatewaytest.config;

import com.example.msaspringcloudgatewaytest.provider.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", predicateSpec -> predicateSpec
                        .path("/api/v1/auth","/login")
                        .and().method(HttpMethod.POST)
                        .filters(gatewayFilterSpec -> gatewayFilterSpec
                                .removeRequestHeader(HttpHeaders.COOKIE)
                        )
                        .uri("lb://MSA-USER-API-TEST")
                )
                .route("board", predicateSpec -> predicateSpec
                        .path("/board/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec
                                .removeRequestHeader(HttpHeaders.COOKIE)
                                .filter(jwtAuthenticationFilter)
                        )
                        .uri("lb://MSA-BOARD-API-TEST")
                )
                .build();
    }
}