package com.example.demo2.example.a6;

import com.example.demo1.game.GameRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

//@Configuration
//@ComponentScan
public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("contextConfiguration.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("game"));
        context.getBean(GameRunner.class).run();
    }
}
