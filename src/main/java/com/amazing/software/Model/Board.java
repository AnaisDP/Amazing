package com.amazing.software.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board {

    private Player player1;
    private Player player2;
    private Stack<Card> deck;

    public Board(Player player1, Player player2) /*throws Exception*/{
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Stack<Card>();
    }

    ///Initialize a shuffled deck this is the main function to generate the deck
    public void GenerateDeck(){
        List<Card> list = GenerateADeck();
        java.util.Collections.shuffle(list);
        this.deck.addAll(list);
    }
    ///Generate a deck with all different race
    private List<Card> GenerateADeck(){
        List<Card> allDeck = new ArrayList<Card>();
        //Dryad
        for(int i = 0; i < 7 ; i++){
            Card card = new Card(new Dryad());
            allDeck.add(card);
        }
        //Elf
        for(int i = 0; i < 7 ; i++){
            Card card = new Card(new Elf());
            allDeck.add(card);
        }
        //Gnome
        for(int i = 0; i < 7 ; i++){
            Card card = new Card(new Gnome());
            allDeck.add(card);
        }
        //Gobelin
        for(int i = 0; i < 7 ; i++){
            Card card = new Card(new Gobelin());
            allDeck.add(card);
        }
        //Korrigan
        for(int i = 0; i < 7 ; i++){
            Card card = new Card(new Korrigan());
            allDeck.add(card);
        }
        //Troll
        for(int i = 0; i < 7 ; i++) {
            Card card = new Card(new Troll());
            allDeck.add(card);
        }
        return allDeck;
    }
}
