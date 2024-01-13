package com.example.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Set;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize
                        .requestMatchers("/").permitAll()
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/homepage").permitAll()
                                .requestMatchers("/contact").permitAll()
                                .requestMatchers("/detail").permitAll()
                                .requestMatchers("/addSuccess/**").permitAll()
                                .requestMatchers("/users").hasRole("ADMIN")
                                .requestMatchers("/items").hasRole("ADMIN")
                                .requestMatchers("/add-item").hasRole("ADMIN")
                                .requestMatchers("/delete-item").hasRole("ADMIN")
                                .requestMatchers("/update-item").hasRole("ADMIN")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/users")
                                .successHandler((request, response, authentication) -> {
                                    // Customize success URL based on user's role
                                    Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
                                    if (roles.contains("ROLE_ADMIN")) {
                                        response.sendRedirect("/users");
                                    } else {
//                                        String username = authentication.getName();
                                        response.sendRedirect("/homepage");
                                    }
                                })
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}