package com.amazing.software.Model;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Board {

    private Player player1;
    private Player player2;
    private Stack<Card> deck;

    public Stack<Card> getDeck() {
        return deck;
    }

    public Board(Player player1, Player player2) /*throws Exception*/ {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Stack<>();
        Shuffle();
    }

    ///Initialize a shuffled deck this is the main function to generate the deck
    public void Shuffle() {
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

    /*public void ActivePower(Player playing, Player opponent, Card card) {
        System.out.println("Player " + playing.toString() + " is playing a " + card.getRace().getName());
        Scanner reader = new Scanner(System.in);
        if (card.getRace() instanceof Dryad) {
            if (opponent.getBoard().isEmpty()) {
                System.out.println("Aucune carte de disponible dans le Board adverse.");
            } else {
                System.out.println("Quelle carte du board de l'adversaire choisissez vous de prendre ?");
                int cardChosen = reader.nextInt();
                card.getRace().Power(playing, opponent, this.deck, cardChosen);
            }
        } else if (card.getRace() instanceof Elf) {
            if(!(playing.getBoard().size() == 1)) {

                System.out.println("Quelle carte de votre board choisissez vous de copier ?");
                int cardChosen = reader.nextInt();
                if (playing.getBoard().get(cardChosen).getRace() instanceof Elf) {
                    ActivePower(playing, opponent, playing.getBoard().get(cardChosen));
                } else if (playing.getBoard().get(cardChosen).getRace() instanceof Dryad) {
                    ActivePower(playing, opponent, playing.getBoard().get(cardChosen));
                } else {
                    card.getRace().Power(playing, opponent, this.deck, cardChosen);
                }

            }
        } else {
            card.getRace().Power(playing, opponent, this.deck, 0);
        }
    }

    public void DistributeCards() {

        while (player1.getHand().size() < 5 && player2.getHand().size() < 5) {
            player1.Draw(this.deck);
            player2.Draw(this.deck);
        }

    }*/

    public void LaunchGame() {
        //Distribute 5 card to each
        Shuffle();
        //DistributeCards();

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        //Lancement de la boucle de jeu
        while (player1.getHand().size() != 0 || player2.getHand().size() != 0) {
            if (deck.size() != 0) {
                player1.Draw(this.deck);
            }
            if (player1.getHand().size() != 0) {
                DisplayBoard();
                System.out.println("Jouez une carte :");
                int cardPlayedP1 = reader.nextInt();
                //Card carte = player1.Play(cardPlayedP1);
                DisplayBoard();
                //ActivePower(player1, player2, carte);
            } else {
                System.out.println("Vous n'avez plus de cartes dans votre main, vous passez votre tour");
            }
            DisplayBoard();

            //L'IA jou tjrs la première carte
            if (deck.size() != 0) {
                player2.Draw(this.deck);
            }
            if (player2.getHand().size() != 0) {
                DisplayBoard();
                //Card carte = player2.Play(0);
                //ActivePower(player2, player1, carte);
            } else {
                System.out.println("Player 2 n'a plus de cartes dans sa main, il passe son tour");
            }


        }
        System.out.println("Fin du jeu !");
        if (player1.getPopulation() > player2.getPopulation()) {
            System.out.println("Player 1 wins !");
        } else if (player1.getPopulation() < player2.getPopulation()) {
            System.out.println("Player 2 wins !");
        } else {
            System.out.println("It's a draw !");
        }
        reader.close();
    }

    private void DisplayBoard() {
        System.out.println("Main joueur 1, " + player1.getHand().size() + " cartes :");
        for (Card carte : player1.getHand()) {
            System.out.print(carte);
            System.out.print(" / ");
        }
        System.out.println("");
        System.out.println("Main joueur 2, " + player2.getHand().size() + " cartes :");
        for (Card carte : player2.getHand()) {
            System.out.print(carte);
            System.out.print(" / ");
        }
        System.out.println("");
        System.out.println("Joueur 1 : Population=" + player1.getPopulation() + ", board :");
        for (Card carte : player1.getBoard()) {
            System.out.print(carte);
            System.out.print(" / ");
        }
        System.out.println("");
        System.out.println("Joueur 2 : Population=" + player2.getPopulation() + ", board :");
        for (Card carte : player2.getBoard()) {
            System.out.print(carte);
            System.out.print(" / ");
        }
        System.out.println("");
    }
}

