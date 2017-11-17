package com.amazing.software.Model;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Board {

    private Player player1;
    private Player player2;
    private Stack<Card> deck;

    public Board(Player player1, Player player2) /*throws Exception*/{
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Stack<Card>();
        Shuffle();
    }

    ///Initialize a shuffled deck this is the main function to generate the deck
    public void Shuffle(){
        List<Card> list = GenerateADeck();
        java.util.Collections.shuffle(list);
        this.deck.addAll(list);
    }
    ///Generate a deck with all different race
    public List<Card> GenerateADeck(){
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

    public void LaunchGame(){
        //Distribute 5 card to each
        while(player1.getHand().size() < 5 && player2.getHand().size() < 5){
            player1.Draw(this.deck);
            player2.Draw(this.deck);
        }

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        //Lancement de la boucle de jeu
        while(deck.size() != 0 && (player1.getHand().size() != 0 || player2.getHand().size() != 0)) {
            DisplayBoard();
            System.out.println("Jouez une carte :");
            int cardPlayedP1 = reader.nextInt();
            player1.Draw(this.deck);
            player1.Play(cardPlayedP1);
            DisplayBoard();

            //L'IA jou tjrs la première carte
            player2.Draw(this.deck);
            player2.Play(0);

        }
        System.out.println("Fin du jeu !");
        reader.close();
    }

    private void DisplayBoard(){
        System.out.println("Main joueur 1:");
        for(Card carte : player1.getHand()){
            System.out.println(carte);
        }
        System.out.println("board joueur 1:");
        for(Card carte : player1.getBoard()){
            System.out.println(carte);
        }
        System.out.println("board joueur 2:");
        for(Card carte : player2.getBoard()){
            System.out.println(carte);
        }
    }
}

