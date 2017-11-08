package com.amazing.software.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Jeu {
    Joueur p1;
    Joueur p2;
    Stack<Carte> deck;

    public Stack<Carte> getDeck() {
        return deck;
    }

    public Joueur getP1() {
        return p1;
    }

    public Jeu(Joueur p1, Joueur p2) {
        this.p1 = p1;
        this.p2 = p2;
        List<Carte> myList = GenerateDeck();
        java.util.Collections.shuffle(myList);
        this.deck = new Stack<Carte>();
        this.deck.addAll(myList);
        DistributeCard();
    }

    private void DistributeCard()
    {
        for(int i =0; i < 5 ; i++){
            this.p1.Draw(this.deck);
            this.p2.Draw(this.deck);
        }
    }

    private List<Carte> GenerateDeck(){
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
}
