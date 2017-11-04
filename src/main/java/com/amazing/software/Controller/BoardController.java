package com.amazing.software.Controller;

import com.amazing.software.Model.Joueur;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Stack;

public class BoardController extends Application{
    private Stack<CarteController> deck;
    private Joueur player1;
    private Joueur player2;


    public BoardController(){
        player1 = new Joueur();
        player2 = new Joueur();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void init() throws Exception {
        super.init();
    }
}
