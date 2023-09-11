package com.example.demo2.examples.a1;

import com.example.demo2.game.GameRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.function.Consumer;

@Configuration
@ComponentScan
public class DepinjectionLauncherApplication {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DepinjectionLauncherApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
