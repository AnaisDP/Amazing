package com.amazing.software.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private List<Carte> handPlayer;
    private List<Carte> terrain;
    private int population;

    public Player(){
        this.handPlayer = new ArrayList<Carte>();
        this.terrain = new ArrayList<Carte>();
        this.population = 0;
    }

    public void Draw(Stack<Carte> deck){
        handPlayer.add(deck.pop());
    }

    public Carte Play(int index){
        return handPlayer.get(index);
    }
    public List<Carte> getHandPlayer() {
        return handPlayer;
    }

    public List<Carte> getTerrain() {
        return terrain;
    }

    public int getPopulation() {
        return population;
    }
}
