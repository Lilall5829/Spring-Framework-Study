package com.example.hello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Hello2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hello2Application.class, args);
    }

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return "redirect:/";
    }
}