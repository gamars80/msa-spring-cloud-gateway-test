package com.example.msaspringcloudgatewaytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RouteLocatorBuilderTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testRouteLocatorBuilderIsNotNull() {
        RouteLocatorBuilder routeLocatorBuilder = applicationContext.getBean(RouteLocatorBuilder.class);
        assertThat(routeLocatorBuilder).isNotNull();
    }
}