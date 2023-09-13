package com.example.demo2.example.a2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        System.out.println("Some initialization logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Say something...");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);
        System.out.println("Initialization od context is completed");
        context.getBean(ClassB.class).doSomething();
    }
}
