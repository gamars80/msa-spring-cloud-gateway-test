//package com.example.msaspringcloudgatewaytest.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic(httpBasic -> httpBasic.disable())
//                .csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.configurationSource(configurationSource()))
//                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS));
//
//
//        http.authorizeHttpRequests(
//                auth -> auth
//                        .requestMatchers(
//                                new AntPathRequestMatcher("/"),
//                                new AntPathRequestMatcher("/css/**"),
//                                new AntPathRequestMatcher("/images/**"),
//                                new AntPathRequestMatcher("/js/**"),
//                                new AntPathRequestMatcher("/h2-console/**"),
//                                new AntPathRequestMatcher("/profile")
//                        ).permitAll()
//                        .anyRequest().permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource configurationSource() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return source;
//    }
//}
//
//
