package com.amazing.software.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {

    @Test
    public void DistributeCard() throws Exception{
        Player p1 = new Player();
        Player p2 = new Player();
        Jeu monJeu = new Jeu(p1, p2);
        assertEquals("p1 should have 5cards",5,p1.getHandPlayer().size());
        assertEquals("p2 should have 5cards",5,p2.getHandPlayer().size());
        assertEquals("deck should have 10cards less",32,monJeu.getDeck().size());
    }

}