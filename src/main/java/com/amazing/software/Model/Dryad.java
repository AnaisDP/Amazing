package com.amazing.software.Model;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Dryad extends Race {
    public Dryad(){
        this.name = "Dryad";
        this.power = "Stole a card in front of your opponent and add it in front of you without activating its power.";
    }
    @Override
    public void Power(Player p1, Player p2, Stack<Card> Deck, int index){
        Scanner reader=new Scanner(System.in);
        if(p2.getBoard().isEmpty()){}
        else{
            System.out.println("Quelle carte du board de l'adversaire choisissez vous de prendre ?");
            int cardchosen = reader.nextInt();
            p1.getBoard().add(p2.getBoard().remove(cardchosen));
        }

    }
}
