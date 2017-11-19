package com.amazing.software.Model;

import java.util.List;

public class Elf extends Race {


    public Elf() {
        this.name = "Elf";
        this.power = "Copy and use the power of one of the card in front of you";
    }
    @Override
    public void Power(Player p1,int index){
        Card card=p1.getBoard().get(index);
    }
}
