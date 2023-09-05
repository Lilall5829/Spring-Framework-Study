package com.example.demo1;

import com.example.demo1.game.GameRunner;
import com.example.demo1.game.MarioGame;
import com.example.demo1.game.PacmanGame;
import com.example.demo1.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
        var game = new PacmanGame();
//        var game = new SuperContraGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
