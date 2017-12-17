package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Gnome extends Race {
    public Gnome(){
        this.name = "Gnome";
        this.power = "Draw 2 cards";
    }
    @Override
    public void Power(Player p1,Player p2, Stack<Card> Deck,Card card){
        if(Deck.size()==1){
            p1.getHand().add(Deck.pop());
        }
        else if(Deck.empty()){

        }
        else{
            p1.getHand().add(Deck.pop());
            p1.getHand().add(Deck.pop());
        }
    }
}
