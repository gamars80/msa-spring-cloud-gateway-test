//package com.example.msaspringcloudgatewaytest.provider.filter;
//
//import com.example.msaspringcloudgatewaytest.annotation.ApiFor;
//import com.example.msaspringcloudgatewaytest.enums.RoleType;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpStatus;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class RoleCheckGatewayFilter implements GatewayFilter {
//
//    private final RequestMappingHandlerMapping handlerMapping;
//
//    public RoleCheckGatewayFilter(RequestMappingHandlerMapping handlerMapping) {
//        this.handlerMapping = handlerMapping;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // 인증되지 않은 요청 처리
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return onError(exchange, "Unauthorized", HttpStatus.UNAUTHORIZED);
//        }
//
//        return Mono.defer(() -> {
//            try {
//                // 요청 경로에 매핑된 컨트롤러와 메서드 정보 가져오기
//                Object handler = handlerMapping.getHandler(exchange).block();
//                if (handler == null) {
//                    return onError(exchange, "Handler Not Found", HttpStatus.NOT_FOUND);
//                }
//
//                // 컨트롤러 또는 메서드의 @ApiRole 애노테이션 읽기
//                ApiFor apiRole = extractApiRoleAnnotation(handler);
//                if (apiRole != null) {
//                    Set<RoleType> requiredRoles = Arrays.stream(apiRole.roles()).collect(Collectors.toSet());
//                    boolean hasRequiredRole = authentication.getAuthorities().stream()
//                            .map(GrantedAuthority::getAuthority)
//                            .anyMatch(requiredRoles::contains);
//
//                    if (!hasRequiredRole) {
//                        return onError(exchange, "Forbidden", HttpStatus.FORBIDDEN);
//                    }
//                }
//            } catch (Exception e) {
//                return onError(exchange, "Error while processing roles", HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//
//            return chain.filter(exchange);
//        });
//    }
//
//    private ApiFor extractApiRoleAnnotation(Object handler) {
//        if (handler instanceof org.springframework.web.method.HandlerMethod) {
//            org.springframework.web.method.HandlerMethod handlerMethod = (org.springframework.web.method.HandlerMethod) handler;
//
//            // 메서드에 @ApiRole이 있는지 확인
//            ApiFor apiRole = handlerMethod.getMethodAnnotation(ApiFor.class);
//            if (apiRole != null) {
//                return apiRole;
//            }
//
//            // 클래스에 @ApiRole이 있는지 확인
//            return handlerMethod.getBeanType().getAnnotation(ApiFor.class);
//        }
//        return null;
//    }
//
//    private Mono<Void> onError(ServerWebExchange exchange, String error, HttpStatus status) {
//        exchange.getResponse().setStatusCode(status);
//        return exchange.getResponse().setComplete();
//    }
//
//}
