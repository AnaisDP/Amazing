package com.amazing.software.Model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static javafx.scene.input.KeyCode.L;

public class Gobelin extends Race {
    public Gobelin(){
        this.name = "Gobelin";
        this.power = "Switch your hand with you opponent";
    }

    public void Power(Joueur joueur1, Joueur joueur2)
    {
        List<Carte> tmp;
        tmp = joueur1.getMain();
        joueur1.setMain(joueur2.getMain());
        joueur2.setMain(tmp);

    }
}
