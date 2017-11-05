package com.amazing.software.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {

    @Test
    public void DistributeCard() throws Exception{
        Joueur p1 = new Joueur();
        Joueur p2 = new Joueur();
        Jeu monJeu = new Jeu(p1, p2);
        assertEquals("p1 should have 5cards",5,p1.getMain().size());
        assertEquals("p2 should have 5cards",5,p2.getMain().size());
        assertEquals("deck should have 10cards less",32,monJeu.getDeck().size());
    }

}