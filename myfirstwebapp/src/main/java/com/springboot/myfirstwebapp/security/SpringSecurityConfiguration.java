package com.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
//        String username = "in28minutes";
//        String password = "123";
        //Click "passwordEncoder" to create the local lambda function above
        //Introduce the username and password to variables and extract the following code to a method
        UserDetails userDetails1 = createNewUser("in28minutes", "123");
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
}
