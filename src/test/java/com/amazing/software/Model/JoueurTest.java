package com.amazing.software.Model;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class JoueurTest {
    @Test
    public void draw() throws Exception {
        Joueur newPlayer = new Joueur();
        Stack<Carte> deck = new Stack();
        deck.push(new Carte(new Troll()));
        newPlayer.Draw(deck);
        assertEquals("Player should have 1 card",1,newPlayer.getMain().size());
        assertEquals("The deck should have one card less",0,deck.size());
    }

}
