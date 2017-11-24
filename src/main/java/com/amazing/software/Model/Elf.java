package com.amazing.software.Model;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Elf extends Race {


    public Elf() {
        this.name = "Elf";
        this.power = "Copy and use the power of one of the card in front of you";
    }

    @Override
    public void Power(Player p1, Player p2, Stack<Card> Deck, int index) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Quelle carte de votre board choisissez vous de copier ?");
        int cardchosen = reader.nextInt();
        p1.getBoard().get(cardchosen).getRace().Power(p1, p2, Deck, index);

    }
}