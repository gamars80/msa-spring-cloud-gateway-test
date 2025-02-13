//package com.example.msaspringcloudgatewaytest.provider.filter;
//
//
//import com.example.msaspringcloudgatewaytest.annotation.ApiFor;
//import com.example.msaspringcloudgatewaytest.enums.RoleType;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class RoleBasedAuthorizationFilter implements GatewayFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        // 요청 URL과 메서드 정보 가져오기
//        String requestUrl = exchange.getRequest().getPath().toString();
//        String httpMethod = exchange.getRequest().getMethod().name();
//
//        // 해당 URL에 맞는 컨트롤러 메서드를 찾아서 @ApiFor 어노테이션 처리
//        try {
////            Method method = getControllerMethod(requestUrl, httpMethod);
////            if (method != null && method.isAnnotationPresent(ApiFor.class)) {
////                ApiFor apiFor = method.getAnnotation(ApiFor.class);
////                List<RoleType> requiredRoles = Arrays.asList(apiFor.roles());
////
////                // 현재 사용자의 역할 확인
////                User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////                List<String> userRoles = currentUser.getAuthorities().stream()
////                        .map(grantedAuthority -> grantedAuthority.getAuthority())
////                        .collect(Collectors.toList());
////
////                // 역할이 일치하는지 확인
////                if (requiredRoles.contains(RoleType.ALL) || userRoles.stream().anyMatch(role -> requiredRoles.contains(RoleType.valueOf(role)))) {
////                    return chain.filter(exchange); // 권한이 일치하면 요청을 계속 진행
////                } else {
////                    return unauthorizedResponse(exchange); // 권한이 없으면 403 반환
////                }
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return chain.filter(exchange); // 어노테이션이 없거나 예외가 발생한 경우 요청을 계속 진행
//    }
//
//    // 요청 URL에 맞는 메서드를 찾기 위한 리플렉션 로직 (단순히 예시)
////    private Method getControllerMethod(String requestUrl, String httpMethod) throws ClassNotFoundException {
////        // 이 부분은 요청 URL에 매핑되는 메서드를 찾아서 반환하는 로직입니다.
////        // 실제로는 스프링의 `RequestMappingHandlerMapping`을 사용하여 해당 URL과 메서드를 찾을 수 있습니다.
////        // 이 예시는 단순화된 것입니다.
////        return MyController.class.getMethod("myApiMethod"); // 예시로 해당 컨트롤러의 메서드를 반환
////    }
//
//    // 권한이 없을 경우의 응답 처리
//    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange) {
//        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//        return exchange.getResponse().setComplete();
//    }
//}
