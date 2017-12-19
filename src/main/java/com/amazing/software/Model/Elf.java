package com.amazing.software.Model;


import java.util.Stack;

public class Elf extends Race {


    public Elf() {
        this.name = "Elf";
        this.power = "Copy and use the power of one of the card in front of you";
    }

    @Override
    public void Power(Player p1, Player p2, Stack<Card> Deck, Card card) {
        if(p1.getBoard().size()!=1){
            card.getRace().Power(p1, p2, Deck, card);
        }


    }
}