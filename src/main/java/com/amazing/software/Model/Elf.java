package com.amazing.software.Model;

import java.util.List;
import java.util.Stack;

public class Elf extends Race {


    public Elf() {
        this.name = "Elf";
        this.power = "Copy and use the power of one of the card in front of you";
    }
    @Override
    public void Power(Player p1,Player p2, Stack<Card> Deck, int index){
        if(p1.getBoard()==null){

        }
        else{
            Card card=p1.getBoard().get(index);
            card.getRace().Power(p1,p2,Deck,index);
        }

    }
}
