package com.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// Overriding the default filter chain which defined by Spring security
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 1. All requests should be authenticated
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        // 2. If a request is not authenticated, a web page is shown
        httpSecurity.httpBasic(withDefaults());
        // 3. CSRF -> POST, PUT
        httpSecurity.csrf().disable();
        return  httpSecurity.build();
    }
}
