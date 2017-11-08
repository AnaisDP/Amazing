package com.amazing.software.Model;

import java.util.Stack;

public class Gnome extends Race {
    public Gnome(){
        this.name = "Gnome";
        this.power = "Draw 2 cards";
    }
    public void Power(Joueur Joueur,Stack<Carte> deck){
        Joueur.Draw(deck);
        Joueur.Draw(deck);
    }
}
