package com.example.springsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
    // Spring protects everything by default! Even the URL is not existed!
    // As for default log in form, user name is "user", password is the string showed on the console when application starts running.
    // Input URL:http://localhost:8080/logout to log out
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World?";
    }
}
