package com.example.demo1;

import com.example.demo1.game.GameRunner;
import com.example.demo1.game.GamingConsole;
import com.example.demo1.game.PacmanGame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

    }
}
