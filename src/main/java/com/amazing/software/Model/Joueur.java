package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Joueur {
    private List<Carte> mainJoueur;

    public List<Carte> getTerrain() {
        return terrain;
    }

    private List<Carte> terrain;
    private int population;


    public List<Carte> getMain() {
        return mainJoueur;
    }

    public Joueur(){}
    public Joueur(List<Carte> mainJoueur){
        this.mainJoueur=mainJoueur;
    }

    public Joueur(List<Carte> mainJoueur, List<Carte> terrain, int population){
        this.mainJoueur = mainJoueur;
        this.terrain = terrain;
        this.population = population;
    }

    public void Draw(Stack<Carte> deck){
        mainJoueur.add(deck.pop());
    }

    public Carte Play(int index){
        return mainJoueur.get(index);

    }
}
