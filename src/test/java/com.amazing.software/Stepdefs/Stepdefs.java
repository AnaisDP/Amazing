package com.amazing.software.Stepdefs;

import com.amazing.software.Model.Jeu;
import com.amazing.software.Model.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


public class Stepdefs {
    private Player p1;
    private Player p2;
    private Jeu monJeu;

    @Given("^I have two players$")
    public void CreateTwoPlayers() throws Exception{
        p1 = new Player();
        p2 = new Player();
    }

    @Then("^each players have (\\d+) cards$")
    public void TestNumberOfCards(int nbCards) throws Exception{
        assertEquals("p1 should have "+nbCards, nbCards,p1.getHandPlayer().size());
        assertEquals("p2 should have "+nbCards,nbCards,p2.getHandPlayer().size());
    }
    @When("^I Create a new Game$")
    public void CreateGame() throws Exception{
        monJeu = new Jeu(p1,p2);
    }

}
