package com.amazing.software.Model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private List<Carte> terrain;
    private ListProperty<Carte> hand;
    private int population;

    public Player(){
        ObservableList<Carte> observableList = FXCollections.observableArrayList();
        this.hand = new SimpleListProperty<Carte>(observableList);
    }



    public void Draw(Stack<Carte> deck){
        hand.add(deck.pop());
    }

    public Carte Play(int index){
        return hand.get(index);
    }





    //Region Get/Set

    public List<Carte> getTerrain() {
        return terrain;
    }

    public void setTerrain(List<Carte> terrain) {
        this.terrain = terrain;
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
