package com.amazing.software.Model;

import java.util.List;

public class Dryad extends Race {
    public Dryad(){
        this.name = "Dryad";
        this.power = "Stole a card in front of your opponent and add it in front of you without activating its power.";
    }
    @Override
    public void Power(Player p1,Player p2,int index){
       p1.getHand().add(p2.getHand().remove(index));
    }
}
