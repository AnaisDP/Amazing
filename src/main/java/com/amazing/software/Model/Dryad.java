package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Dryad extends Race {
    public Dryad(){
        this.name = "Dryad";
        this.power = "Stole a card in front of your opponent and add it in front of you without activating its power.";
    }
    @Override
    public void Power(Player p1, Player p2, Stack<Card> Deck, int index){
        if(p2.getBoard()==null){

        }
        else{
            p1.getBoard().add(p2.getBoard().remove(index));
        }
    }
}
