package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Carte;
import com.amazing.software.Model.Jeu;
import com.amazing.software.Model.Joueur;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

public class BoardController {


    @FXML
    private GridPane cardP1;
    @FXML
    private GridPane cardP2;

    private Joueur player1;
    private Joueur player2;
    private Jeu game;


    public BoardController() throws Exception{
        this.player1 = new Joueur();
        this.player2 = new Joueur();
        this.game = new Jeu(player1,player2);
    }



    public void InitHands()throws Exception{
        int count = 0;
        //Carte joueur
        for(Carte carte : player1.getMain()){
            URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            fxmlLoader.setController(new CarteController(carte));
            Pane pane = (Pane)fxmlLoader.load();
            cardP1.add(pane,count,0);
            count++;
        }
        //Carte IA
        count = 0;
        for(Carte carte : player2.getMain()){
            URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            fxmlLoader.setController(new CarteController(carte));
            Pane pane = (Pane)fxmlLoader.load();
            cardP2.add(pane,count,0);
            count++;
        }
       /* URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
        fxmlLoader.setController(new CarteController(player1.getMain().get(0)));
        Pane pane = (Pane)fxmlLoader.load();
        cardP1.add(pane,i,0);*/
    }


}
