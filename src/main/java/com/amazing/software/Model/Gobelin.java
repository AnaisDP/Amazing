package com.amazing.software.Model;

import java.util.List;

public class Gobelin extends Race {
    public Gobelin(){
        this.name = "Gobelin";
        this.power = "Switch your hand with you opponent";
    }
    @Override
    public void Power(Player p1,Player p2){
        List<Card> tmp=p1.getBoard();
        p1.setBoard(p2.getBoard());
        p2.setBoard(tmp);
    }
}
