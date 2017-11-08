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
    private Player player1;
    private Player player2;
    private Stack<Carte> deck;
    //endregion


    public BoardController() throws Exception{
        this.player1 = new Player();
        this.player2 = new Player();
        this.deck = new Stack<Carte>();
    }


    //region méthodes
    ///Initialize a shuffled deck this is the main function to generate the deck
    private void GenerateDeck(){
        List<Carte> list = GenerateADeck();
        java.util.Collections.shuffle(list);
        this.deck.addAll(list);
    }
    ///Generate a deck with all different race
    private List<Carte> GenerateADeck(){
        List<Carte> myList = new ArrayList<Carte>();
        //Dryad
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Dryad());
            myList.add(card);
        }
        //Elf
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Elf());
            myList.add(card);
        }
        //Gnome
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Gnome());
            myList.add(card);
        }
        //Gobelin
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Gobelin());
            myList.add(card);
        }
        //Korrigan
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Korrigan());
            myList.add(card);
        }
        //Troll
        for(int i = 0; i < 7 ; i++) {
            Carte card = new Carte(new Troll());
            myList.add(card);
        }
        return myList;
    }

    ///Distribute 5cards to the player from the deck, used to launch the game
    public  void Distribute(Player player){
       while(player.getHand().size()<5){
           player.Draw(this.deck);
       }
    }

    ///First function to call in the main
    public void StartGame()throws Exception{
        GenerateDeck();
        Distribute(player1);
        Distribute(player2);
        //System.out.println(handUiP1.getChildren().size());

    }
    //endregion

    //TODO Listener sur main du player2
    //TODO Listener sur terrain des players
    //TODO Event sur les listeners créé
    //TODO Pioche

    //Cette fonction est appellé lorsque que BoardController est completement initialisé
    @Override
    public void initialize(URL location, ResourceBundle resources){
        gridPaneInit();
        InitListener();
    }

    //region InitMethods
    private void gridPaneInit(){
        InitHandUi();
        InitBoardUi();
    }

    private void InitHandUi(){

        //Space between 2 card
        this.handUiP1.setVgap(15);
        this.handUiP1.setHgap(15);
        this.handUiP1.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne 1 colonne (handPlayer vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.handUiP1.getRowConstraints().add(rowConstraints);
    }
    private void InitBoardUi(){
        //Space between 2 card
        this.boardUiP1.setVgap(15);
        this.boardUiP1.setHgap(15);
        this.boardUiP1.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne 1 colonne (handPlayer vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.boardUiP1.getRowConstraints().add(rowConstraints);
    }
    public void InitListener(){

        //Ajout de listeners sur les propriété hand et terrain des Player1 et player2
        //region Listener player1 handProperty
        this.player1.handProperty().addListener(new ListChangeListener<Carte>() {
            @Override
            public void onChanged(Change<? extends Carte> c) {
                while (c.next()){
                    if(c.wasAdded()){
                        System.out.println("Card +"+c.toString()+" was add at "+c.getFrom());
                        try {
                            final CarteController carteController = new CarteController(player1.getHand().get(c.getFrom()));
                            ColumnConstraints columnConstraints = new ColumnConstraints();
                            handUiP1.getColumnConstraints().add(columnConstraints);
                            handUiP1.add(carteController.getPane(),c.getFrom(),0);
                            handUiP1.setAlignment(Pos.CENTER);
                            System.out.println("Card "+ c.toString()+ " was add in P1Grid at pos : "+c.getFrom());
                            //region setMouseClick
                            carteController.getPane().setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    System.out.println("Carte "+carteController.toString()+" clicked");
                                    for(int i = 0 ; i < player1.getHand().size() ; i++){
                                        if(player1.getHand().get(i) == carteController.getCarte()){
                                            player1.getBoard().add(player1.getHand().get(i));
                                            player1.getHand().remove(player1.getHand().get(i));
                                            System.out.println("Placement affected");
                                        }
                                    }
                                }
                            });
                            //endregion
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.toString());
                        }

                    }
                    if(c.wasRemoved()){
                        System.out.println("Card +"+c.toString()+" was removed at "+c.getFrom());
                        handUiP1.getChildren().remove(c.getFrom());
                        handUiP1.setAlignment(Pos.CENTER);

                    }
                }
            }
        });
        //endregion
        //region Listener player1 boardProperty
        this.player1.boardProperty().addListener(new ListChangeListener<Carte>() {
            @Override
            public void onChanged(Change<? extends Carte> c) {
                while(c.next()){
                    if(c.wasAdded()){
                        System.out.println("Card +"+c.toString()+" was add at "+c.getFrom());
                        try {
                            CarteController carteController = new CarteController(player1.getBoard().get(c.getFrom()));
                            ColumnConstraints columnConstraints = new ColumnConstraints();
                            boardUiP1.getColumnConstraints().add(columnConstraints);
                            boardUiP1.add(carteController.getPane(),c.getFrom(),0);
                            System.out.println("Card "+ c.toString()+ " was add in P1Board at pos : "+c.getFrom());
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.toString());
                        }

                    }
                }
            }
        });
        //endregion
        //region pioche
        this.pioche.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player1.Draw(deck);
            }
        });
        //endregion
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
