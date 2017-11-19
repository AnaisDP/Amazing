package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Troll extends Race {
    public Troll(){
        this.name = "Troll";
        this.power = "Swap the cards in front of you with the cards in front of your opponent";
    }
    @Override
    public void Power(Player p1,Player p2,Stack<Card> Deck,int index){
        List<Card> tmp=p1.getBoard();
        p1.setBoard(p2.getBoard());
        p2.setBoard(tmp);
    }
}
