package com.amazing.software.Model;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void draw() throws Exception {
        Player newPlayer = new Player();
        Stack<Carte> deck = new Stack();
        deck.push(new Carte(new Troll()));
        newPlayer.Draw(deck);
        assertEquals("Player should have 1 card",1,newPlayer.getHand().size());
        assertEquals("The deck should have one card less",0,deck.size());
    }

}
