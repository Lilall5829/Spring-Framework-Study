package com.example.demo2.example.a4;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependency are ready!");
    }
    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }
    @PreDestroy
    public void cleanup(){
        System.out.println("Cleanup");
    }

}
@Component
class SomeDependency{

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}
@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
