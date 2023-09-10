package com.example.demo1;

import com.example.demo1.game.GameRunner;
import com.example.demo1.game.GamingConsole;
import com.example.demo1.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
@Bean
    public GamingConsole game() {
    var game = new PacmanGame();
    return game;
}
@Bean
    public GameRunner gameRunner(GamingConsole game){
    var gameRunner = new GameRunner(game);
    return gameRunner;
}
}
