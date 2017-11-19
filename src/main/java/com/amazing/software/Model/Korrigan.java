package com.amazing.software.Model;

import java.util.Random;
import java.util.Stack;

public class Korrigan extends Race {


    public Korrigan() {
        this.name = "Korrigan";
        this.power = "Draw 2 random cards within your opponent hand";
    }
    @Override
    public void Power(Player p1,Player p2,Stack<Card> Deck,int index){
        for(int i=0;i<2;i++){
           int randomNum = (int)(Math.random() * p2.getHand().size());
           p1.getHand().add(p2.getHand().remove(randomNum));
        }
    }


}
