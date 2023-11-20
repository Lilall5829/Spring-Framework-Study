package com.example.springsecurity.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

import static org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION;

@Configuration
@EnableWebSecurity
public class BasicAuthSecurityConfiguration {
    // Purpose: Disabling csrf(Cross-Site Request Forgery)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Filter chain, one by one chained together
        return
                http
                        .authorizeHttpRequests(
                                auth ->
                                        auth
                                                .anyRequest().authenticated()
                        )
                        // Stateless REST API
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .httpBasic(Customizer.withDefaults())
//                        .csrf().disable() //: This method was deprecated
                        .csrf(AbstractHttpConfigurer::disable)
                        // Allows embedding the application in a frame with the same origin(such as h2), or the h2 interface will not show properly
                        .headers(header -> {
                            header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
                        })
                        .build();
    }
    // Allow CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            // Override addCorsMappings
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow any URl and any request from port 3000
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
            }
        };
    }

    // There are 2 ways to store users nad passwords.
    // 1. Store in memory: With the following code, you can store your users and passwords in memory and comment the user and password at application.properties
    // But this method is not recommended for production
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("lila")
//                .password("{noop}123")
//                .authorities("read")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}123")
//                .roles("ADMIN")
//                .build();
//    // Pass ALL users  and store them in memory by the following method.
//        return new InMemoryUserDetailsManager(user,admin);
//    }

    // 2. Store users and passwords in an embedded database
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION) // This parameter comes from "JdbcDaoImpi.class"
                .build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("lila")
                .password("{noop}123") //The {noop} in the password indicates that the password is stored in plaintext. This is suitable for demonstration purposes; in a real application, passwords should be hashed.
                .authorities("read","write")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{noop}123")
                .roles("ADMIN","USER")
                .build();
        // Here is different from store in memory. Using jdbc
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource());
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }
}
