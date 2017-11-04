package com.amazing.software.Model;

import java.util.Stack;

public class Jeu {
    Joueur p1;
    Joueur p2;
    Stack<Carte> deck;

    public Jeu(Joueur p1,Joueur p2) {
        this.p1 = p1;
        this.p2 = p2;
        //TODO Implémenter la méthode GenerateDeck qui genere un deck (42cartes, 6races differente : 7cartes de chaque race)
        //this.deck = GenerateDeck();
        //TODO Implémenter la méthode DistributeCard qui distribue 5cartes a chaque joueurs
    }
}
