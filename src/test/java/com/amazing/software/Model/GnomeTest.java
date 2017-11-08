package com.amazing.software.Model;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class GnomeTest {
    @Test
    public void power() throws Exception {
        Joueur newPlayer = new Joueur();
        Stack<Carte> main = new Stack();
        main.push(new Carte(new Gnome()));
        newPlayer.Play(0);
        Stack<Carte> deck = new Stack();
        deck.push(new Carte(new Gnome()));
        deck.push(new Carte(new Troll()));
        assertEquals("Player should have 2 new cards", 2, newPlayer.getMain().size());
        assertEquals("The deck should have 2 cards less", 0, deck.size());
    }
}