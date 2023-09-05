package com.example.demo1;

import com.example.demo1.game.GameRunner;
import com.example.demo1.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorld {
    public static void main(String[] args) {
        //Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        //Configure the things that we want Spring to manage -@Configuration
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
//        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean("myAddress"));
        System.out.println(context.getBean("personParameter"));
    }
}
