package com.amazing.software.Stepdefs;

import com.amazing.software.Model.Jeu;
import com.amazing.software.Model.Joueur;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;


public class Stepdefs {
    private Joueur p1;
    private Joueur p2;
    private Jeu monJeu;

    @Given("^I have two players$")
    public void CreateTwoPlayers() throws Exception{
        p1 = new Joueur();
        p2 = new Joueur();
    }

    @Then("^each players have (\\d+) cards$")
    public void TestNumberOfCards(int nbCards) throws Exception{
        assertEquals("p1 should have "+nbCards, nbCards,p1.getMain().size());
        assertEquals("p2 should have "+nbCards,nbCards,p2.getMain().size());
    }
    @When("^I Create a new Game$")
    public void CreateGame() throws Exception{
        monJeu = new Jeu(p1,p2);
    }

    @Given("^I have a player$")
    public void CreatePlayer() throws Exception{
        p1 = new Joueur();
    }

    @Then("^He have (\\d+) card$")
    public void NbOfCards(int nbCards) throws Exception{
        assertEquals("p1 should have "+nbCards, nbCards,p1.getMain().size());
    }

    @When("^He draw (\\d+) card$")
    public void DrawCard(int NbCards) throws  Exception{
    }

}
