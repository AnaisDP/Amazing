package com.amazing.software.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class JoueurTest {
    @Test
    public void play() throws Exception {
        List<Carte> mainJoueur = new ArrayList<Carte>();

        Carte carte = new Carte(new Race());
        mainJoueur.add(carte);
        Joueur joueur1 = new Joueur(mainJoueur);

        joueur1.Play(0);
        assertEquals(joueur1.getMain().size(), 0);
        assertEquals(joueur1.getTerrain().size(), 1);

    }

}