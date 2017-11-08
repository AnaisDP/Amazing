package com.amazing.software.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Joueur {
    private List<Carte> main;



    private List<Carte> terrain;
    private int population;

    public Joueur(){
        this.main = new ArrayList<Carte>();
        this.terrain = new ArrayList<Carte>();
        this.population = 0;
    }

    public void Draw(Stack<Carte> deck){
        main.add(deck.pop());
    }

    public Carte Play(int index){
        return main.get(index);
    }
    public List<Carte> getMain() {
        return main;
    }
    public void setMain(List<Carte> main) {this.main = main;}
    public void setTerrain(List<Carte> terrain) { this.terrain = terrain; }

    public List<Carte> getTerrain() {
        return terrain;
    }

    public int getPopulation() {
        return population;
    }
}
