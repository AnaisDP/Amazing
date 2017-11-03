package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Joueur {
    private List<Carte> main;
    private List<Carte> terrain;
    private int population;

    public Joueur(List<Carte> main, List<Carte> terrain, int population){
        this.main = main;
        this.terrain = terrain;
        this.population = population;
    }

    public void Draw(Stack<Carte> deck){
        main.add(deck.pop());
    }

    public Carte Play(int index){
        return main.get(index);
    }
}
