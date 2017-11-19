package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Gobelin extends Race {
    public Gobelin(){
        this.name = "Gobelin";
        this.power = "Switch your hand with you opponent";
    }
    @Override
    public void Power(Player p1,Player p2,Stack<Card> Deck,int index){
        List<Card> tmp=p1.getHand();
        p1.setHand(p2.getHand());
        p2.setHand(tmp);
    }
}
