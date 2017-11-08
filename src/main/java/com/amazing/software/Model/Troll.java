package com.amazing.software.Model;

import java.util.List;

public class Troll extends Race {
    public Troll(){
        this.name = "Troll";
        this.power = "Swap the cards in front of you with the cards in front of your opponent";
    }

    public void Power(Joueur joueur1, Joueur joueur2)
    {
        List<Carte> tmp;
        tmp = joueur1.getTerrain();
        joueur1.setTerrain(joueur2.getTerrain());
        joueur2.setTerrain(tmp);

    }
}
