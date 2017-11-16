package com.amazing.software.Model;

public class Game {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Board boardGame = new Board(player1, player2);

    public Game(){
        boardGame.GenerateDeck();
    }
}
