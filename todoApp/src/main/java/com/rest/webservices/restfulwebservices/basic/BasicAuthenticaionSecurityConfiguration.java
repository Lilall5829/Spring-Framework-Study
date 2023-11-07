package com.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticaionSecurityConfiguration {
    // Purpose: Disabling csrf(Cross-Site Request Forgery)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Filter chain, one by one chained together
        // 1. Authenticate all requests
        return
                http
                        .authorizeHttpRequests(
                                auth ->
                                        auth
                                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                                .anyRequest().authenticated()
                        )
                        // 2. Basic authentication, also need to change HelloWorldController.java!
                        .httpBasic(Customizer.withDefaults())
                        // Stateless REST API
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .csrf().disable()
                        .build();
    }
    // After this, we need to change our front end code at HelloWorldApiService.jsx
}
