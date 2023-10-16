package com.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP or Database
    //In Memory
    // InMemoryUserDetailsManager can receive several user details, like InMemoryUserDetailsManager(UserDetails1...UserDetailsN)
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        //Encode the password
//        Inline username and password to createNewUser: select the variable name and right click choose the Refactor -> Inline variable or using shortcut ctrl + alt + N
//        String username = "leo";
//        String password = "123";
        //Click "passwordEncoder" to create the local lambda function above
        //Introduce the username and password to variables and extract the following code to a method
        UserDetails userDetails1 = createNewUser("leo", "123");
        UserDetails userDetails2 = createNewUser("lila", "123");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password).roles("USER","ADMIN").build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //All URLs are protected by Security
    // Throws exception
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        //Don't forget to import Customizer.withDefaults!
        http.formLogin(withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
}
