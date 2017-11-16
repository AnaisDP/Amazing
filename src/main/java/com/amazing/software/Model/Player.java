package com.amazing.software.Model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private List<Card> board;
    private List<Card> hand;
    private int population;
    private int score;

    public Player(){
    this.board = new ArrayList<Card>();
    this.hand = new ArrayList<Card>();
    population = 0;
    score = 0;
    }

    public List<Card> getBoard() {
        return board;
    }

    public void setBoard(List<Card> board) {
        this.board = board;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getPopulation() {
        return this.hand.size();
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void Draw(Stack<Card> deck){
        hand.add(deck.pop());
    }

    public Card Play(int index){
        return hand.get(index);
    }





}
