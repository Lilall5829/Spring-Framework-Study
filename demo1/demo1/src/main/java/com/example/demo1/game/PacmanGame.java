package com.example.demo1.game;

public class PacmanGame implements GamingConsole{
    public void up(){
        System.out.println("Up!");
    }
    public void down(){
        System.out.println("Sit down!");
    }
    public void left(){
        System.out.println("Go back!");
    }
    public void right(){
        System.out.println("Shoot a bullet!");
    }
}
