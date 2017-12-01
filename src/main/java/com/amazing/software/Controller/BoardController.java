package com.amazing.software.Controller;

import com.amazing.software.Model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {

    //region attributs
    //TODO assigné dans la vue
    @FXML
    private GridPane handUiP1; //Ui handPlayer du joueur 1
    @FXML
    private GridPane handUiP2; // Ui handPlayer du joueur 2
    @FXML
    private Pane pioche; //Ui pour la pioche
    @FXML
    private GridPane boardUiP1; //Ui pour le terrain du joueur 1
    @FXML
    private GridPane boardUiP2; //Ui pour le terrain du joueur 2

    //Variable pour le jeu
    private Player player1;
    private Player player2;
    private Stack<Card> deck;
    //endregion


    public BoardController() throws Exception{
        this.player1 = new Player();
        this.player2 = new Player();
        this.deck = new Stack<Card>();
        Shuffle();
    }


    //region méthodes
    ///Initialize a shuffled deck this is the main function to generate the deck
    public void Shuffle(){
        List<Card> list = GenerateADeck();
        java.util.Collections.shuffle(list);
        this.deck.addAll(list);
    }
    ///Generate a deck with all different race
    public List<Card> GenerateADeck() {
        List<Card> allDeck = new ArrayList<>();
        //Dryad
        for (int i = 0; i < 7; i++) {
            allDeck.add(new Card(new Dryad()));
            allDeck.add(new Card(new Gobelin()));
            allDeck.add(new Card(new Troll()));
            allDeck.add(new Card(new Korrigan()));
            allDeck.add(new Card(new Gnome()));
            allDeck.add(new Card(new Elf()));
        }
        return allDeck;
    }

    public void DistributeCards() throws Exception{
        while(player1.getHand().size() < 5 || player2.getHand().size() < 5){
            //Creation d'une vue carte controller
            CardController cardController = new CardController(player1.Draw(this.deck));
            //Création d'une nouvelle colonne dans le GridHandUi
            ColumnConstraints columnConstraints = new ColumnConstraints();
            handUiP1.getColumnConstraints().add(columnConstraints);
            //Bind de la CC au GridHandUi
            handUiP1.add(cardController.getPane(),player1.getHand().size(),0); //L'index de la colonne est donnée par la taille de la main

            CardController cardController1 = new CardController(player2.Draw(this.deck));
            ColumnConstraints columnConstraints1 = new ColumnConstraints();
            handUiP2.getColumnConstraints().add(columnConstraints);
            handUiP2.add(cardController1.getPane(),player2.getHand().size(),0);
            //TODO Do the same for P2
        }
    }
    ///First function to call in the main
    public void StartGame()throws Exception{
        DistributeCards();
        //TODO Function to distribute 5card to each player on UI
    }

    public int PopulationUpdate(){

        int populationPlayer1 = player1.getPopulation();
        //int populationPlayer2 = player2.getPopulation();
        return populationPlayer1;
        //return populationPlayer2;
    }
    //endregion

    //Cette fonction est appellée lorsque que BoardController est completement initialisé
    @Override
    public void initialize(URL location, ResourceBundle resources){
        GridsPanesInit();
    }

    //region InitMethods
    private void GridsPanesInit(){
        InitHandUi();
        InitBoardUi();
    }
    private void InitHandUi(){

        //Space between 2 card
        this.handUiP1.setVgap(15);
        this.handUiP1.setHgap(15);
        this.handUiP1.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne (handPlayer vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.handUiP1.getRowConstraints().add(rowConstraints);

        this.handUiP2.setVgap(15);
        this.handUiP2.setHgap(15);
        this.handUiP2.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne (handPlayer vide)
        final RowConstraints rowConstraints1 = new RowConstraints();
        this.handUiP2.getRowConstraints().add(rowConstraints1);
    }
    private void InitBoardUi(){
        //Space between 2 card
        this.boardUiP1.setVgap(15);
        this.boardUiP1.setHgap(15);
        this.boardUiP1.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne (boardPlayer vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.boardUiP1.getRowConstraints().add(rowConstraints);
    }
    //endregion

    //region Get/Set
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public GridPane getHandUiP1() {return handUiP1;}
    //endregion
}