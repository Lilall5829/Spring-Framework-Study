package com.example.demo2.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo2.game")
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);
//            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

    }
}
