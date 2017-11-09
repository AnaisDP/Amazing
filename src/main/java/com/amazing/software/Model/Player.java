package com.amazing.software.Model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private ListProperty<Carte> board;
    private ListProperty<Carte> hand;
    private int population;

    public Player(){
        ObservableList<Carte> observableList = FXCollections.observableArrayList();
        this.hand = new SimpleListProperty<Carte>(observableList);
        ObservableList<Carte> observableList1 = FXCollections.observableArrayList();
        this.board = new SimpleListProperty<Carte>(observableList1);
    }



    public void Draw(Stack<Carte> deck){
        hand.add(deck.pop());
    }

    public Carte Play(int index){
        return hand.get(index);
    }





    //Region Get/Set


    public ObservableList<Carte> getBoard() {
        return board.get();
    }

    public ListProperty<Carte> boardProperty() {
        return board;
    }

    public void setBoard(ObservableList<Carte> board) {
        this.board.set(board);
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {this.population = population;}

    //-------

    public ObservableList<Carte> getHand() {return hand.get();}

    public ListProperty<Carte> handProperty() {return hand;}

    public void setHand(ObservableList<Carte> hand) {this.hand.set(hand);}
    //EndRegion
}
