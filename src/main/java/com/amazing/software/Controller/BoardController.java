package com.amazing.software.Controller;

import com.amazing.software.Model.*;
import cucumber.api.java.hu.Ha;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Label;
import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

public class BoardController implements Initializable {

    //region attributs
    //TODO assigné dans la vue
    @FXML
    private Label PopJ1;
    @FXML
    private Label PopJ2;
    @FXML
    private Label ScoreJ1;
    @FXML
    private Label ScoreJ2;
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
    @FXML
    //GameMaster textfield who explain all things that change
    private TextField gameMasterText;

    //Variable pour le jeu
    private Player player1;
    private Player player2;
    private IA ia;
    public Stack<Card> getDeck() {
        return deck;
    }

    private Stack<Card> deck;



    private boolean waitingForCard=false;

    private boolean waitingForCard2 = false;
    private Card tempCard;
    //endregion

    public BoardController() throws Exception{
        this.player1 = new Player();
        this.player2 = new Player();
        this.deck = new Stack<Card>();
        Shuffle();
    }
    public void turnIA(){
        player2.Draw(deck);
        this.ia=new IA(player2,player1);
        int index=ia.makeMove();
        if(player2.getHand().get(index).getRace().getName()=="Elf"){
            int index2=ia.chooseCardBoard();
            player2.getHand().get(index).getRace().Power(player2,player1,deck,player2.getBoard().get(index2));
        }
        else if(player2.getHand().get(index).getRace().getName()=="Dryad"){

        }
        else{
            player2.getHand().get(index).getRace().Power(player2,player1,deck,null);
        }
        player2.Play(player2.getHand().get(index));
        player1.Draw(deck);
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
            player1.Draw(this.deck);
            player2.Draw(this.deck);
        }
        HandUpdate();
    }
    ///First function to call in the main
    public void StartGame()throws Exception{
        DistributeCards();
    }
    public void WaitingForCard(Card card,Boolean bool){
        waitingForCard=bool;
        tempCard=card;
    }

    public void WaitingForCard2(Card card,Boolean bool){
        waitingForCard2=bool;
        tempCard=card;
    }

    //endregion

    //region Update
    public void UpdateBoard() throws Exception {
        boardUiP1.getChildren().clear();
        boardUiP1.getColumnConstraints().clear();
        int count=0;
        for (Card card : getPlayer1().getBoard()) {
            System.out.println("Player1:"+card.getRace().getName());
            CardController newCard = new CardController(card,this);
            ColumnConstraints columnConstraints = new ColumnConstraints();
            boardUiP1.getColumnConstraints().add(columnConstraints);
            boardUiP1.add(newCard.getPane(),count,0);
            count++;
        }
        boardUiP2.getChildren().clear();
        boardUiP2.getColumnConstraints().clear();
        count=0;
        for (Card card : getPlayer2().getBoard()) {
            System.out.println("Player2:"+card.getRace().getName());
            CardController newCard = new CardController(card,this);
            ColumnConstraints columnConstraints = new ColumnConstraints();
            boardUiP2.getColumnConstraints().add(columnConstraints);
            boardUiP2.add(newCard.getPane(),count,0);
            count++;
        }

    }
    public void HandUpdate() throws Exception{
        //Refresh player1
        handUiP1.getChildren().clear();
        handUiP1.getColumnConstraints().clear();
        int count = 0;
        for (Card card : getPlayer1().getHand()) {
            CardController cardController = new CardController(card,this);
            ColumnConstraints columnConstraints = new ColumnConstraints();
            handUiP1.getColumnConstraints().add(columnConstraints);
            handUiP1.add(cardController.getPane(),count,0);
            count++;
        }

        //Refresh player2
        handUiP2.getChildren().clear();
        handUiP2.getColumnConstraints().clear();
        count = 0;
        for (Card card : getPlayer2().getHand()) {
            CardController cardController = new CardController(card,this);
            ColumnConstraints columnConstraints = new ColumnConstraints();
            handUiP2.getColumnConstraints().add(columnConstraints);
            handUiP2.add(cardController.getPane(),count,0);
            count++;
        }
    }
    public void UpdateGameMaster(String message){
        gameMasterText.setText("\n"+ message);
    }
    public void UpdateDeckFinished(){
        pioche.setVisible(false);
        pioche.setDisable(true);
    }
    public void PopulationUpdate(){
        String pop;
        pop=""+player1.getPopulation();
        PopJ1.setText(pop);
        pop=""+player2.getPopulation();
        PopJ2.setText(pop);

    }
    public void ScoreUpdate(){
        List<String> liste= new ArrayList<String>();
        liste.add("Gobelin");
        liste.add("Elf");
        liste.add("Troll");
        liste.add("Dryad");
        liste.add("Gnome");
        liste.add("Korrigan");
        for (Card card : player1.getBoard()) {
            if(liste.contains(card.getRace().getName())){
                liste.remove(card.getRace().getName());
            }
        }
        if (liste.isEmpty()){
            int scoreint=3+player1.getPopulation();
            player1.setScore(scoreint);
        }
        else{
            player1.setScore(player1.getPopulation());
        }
        String score=""+player1.getScore();
        ScoreJ1.setText("Score1: "+score);
        liste= new ArrayList<String>();
        liste.add("Gobelin");
        liste.add("Elf");
        liste.add("Troll");
        liste.add("Dryad");
        liste.add("Gnome");
        liste.add("Korrigan");
        for (Card card : player2.getBoard()) {
            if(liste.contains(card.getRace().getName())){
                liste.remove(card.getRace().getName());
            }
        }
        if (liste.isEmpty()){
            int scoreint=3+player2.getPopulation();
            player2.setScore(scoreint);
        }
        else{
            player2.setScore(player2.getPopulation());
        }
        score=""+player2.getScore();
        ScoreJ2.setText("Score2: "+score);
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
        //Space between 2 card
        this.boardUiP2.setVgap(15);
        this.boardUiP2.setHgap(15);
        this.boardUiP2.setAlignment(Pos.CENTER);
        //Initialisation du GridPane avec 1 ligne (boardPlayer vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.boardUiP1.getRowConstraints().add(rowConstraints);
    }

    private void InitGameMaster(){

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
    public GridPane getBoardUiP1() {
        return boardUiP1;
    }

    public void setBoardUiP1(GridPane boardUiP1) {
        this.boardUiP1 = boardUiP1;
    }

    public GridPane getBoardUiP2() {
        return boardUiP2;
    }

    public void setBoardUiP2(GridPane boardUiP2) {
        this.boardUiP2 = boardUiP2;
    }

    public boolean getWaitingForCard() {
        return waitingForCard;
    }

    public void setWaitingForCard(boolean waitingForCard) {
        this.waitingForCard = waitingForCard;
    }

    public Card getTempCard() {
        return tempCard;
    }

    public void setTempCard(Card tempCard) {
        this.tempCard = tempCard;
    }

    public boolean getWaitingForCard2() {
        return waitingForCard2;
    }

    public void setWaitingForCard2(boolean waitingForCard2) {
        this.waitingForCard2 = waitingForCard2;
    }
    //endregion
}
