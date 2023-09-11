package com.example.demo2.example.a0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class YourBusinessClass {

    Dependency1 dependency1;
    Dependency2 dependency2;

//    @Autowired
    //Constructor injection is recommended
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        System.out.println("Setter Injection: setDependency1");
        this.dependency2 = dependency2;
        System.out.println("Setter Injection: setDependency2");

    }
    //    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection: setDependency2");
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection: setDependency2");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "Using" + dependency1 + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(YourBusinessClass.class));

    }
}
