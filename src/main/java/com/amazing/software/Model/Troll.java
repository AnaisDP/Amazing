package com.amazing.software.Model;

import java.util.List;

public class Troll extends Race {
    public Troll(){
        this.name = "Troll";
        this.power = "Swap the cards in front of you with the cards in front of your opponent";
    }
    @Override
    public void Power(Player p1,Player p2){
        List<Card> tmp=p1.getHand();
        p1.setHand(p2.getHand());
        p2.setHand(tmp);
    }
}
