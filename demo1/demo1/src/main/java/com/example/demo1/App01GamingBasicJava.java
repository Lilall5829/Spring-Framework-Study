package com.example.demo1;

import com.example.demo1.game.GameRunner;
import com.example.demo1.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
        var game = new PacmanGame();
//        var game = new SuperContraGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
