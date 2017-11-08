package com.amazing.software.Controller;

import com.amazing.software.Model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {

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

    //Listen if an object has changed

    private Stack<Carte> deck;

    public BoardController() throws Exception{
        this.player1 = new Player();
        this.player2 = new Player();
        this.deck = new Stack<Carte>();
    }


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

    }


    //TODO Listener sur main du player2
    //TODO Listener sur terrain des players
    //TODO Event sur les listeners créé
    //TODO Pioche

    @Override
    //Cette fonction est appellé lorsque que BoardController est completement initialisé
    public void initialize(URL location, ResourceBundle resources){
        gridPaneInit();
        InitListener();
    }

    //region InitMethods
    private void gridPaneInit(){
        //Space between 2 card
        this.handUiP1.setVgap(15);
        this.handUiP1.setHgap(15);

        this.handUiP1.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne 1 colonne (handPlayer vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.handUiP1.getRowConstraints().add(rowConstraints);
        final ColumnConstraints columnConstraints = new ColumnConstraints();
        this.handUiP1.getColumnConstraints().add(columnConstraints);
        this.handUiP1.setGridLinesVisible(true);
    }
    public void InitListener(){

        //Ajout d'un listener sur la propriété hand de Player1
        this.player1.handProperty().addListener(new ListChangeListener<Carte>() {
            @Override
            public void onChanged(Change<? extends Carte> c) {
                while (c.next()){
                    if(c.wasAdded()){
                        System.out.println("Card +"+c.toString()+" was add at "+c.getFrom());
                        try {
                            CarteController carteController = new CarteController(player1.getHand().get(c.getFrom()));
                            ColumnConstraints columnConstraints = new ColumnConstraints();
                            handUiP1.getColumnConstraints().add(columnConstraints);
                            handUiP1.add(carteController.getPane(),c.getFrom(),0);
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.toString());
                        }

                    }
                }
            }
        });
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
