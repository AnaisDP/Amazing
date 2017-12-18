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
    this.population = 0;
    this.score = 0;
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
        return this.board.size();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Card Draw(Stack<Card> deck){
        if (deck.isEmpty()) {
            return null;
        }
        Card card = deck.pop();
        hand.add(card);
        return card;
    }

    public void Play(Card card){
        this.board.add(card);
        hand.remove(card);
    }
}
