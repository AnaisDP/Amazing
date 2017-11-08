package com.amazing.software.Stepdefs;

import com.amazing.software.Controller.BoardController;
import com.amazing.software.Model.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


public class Stepdefs {
    private Player p1;
    private Player p2;
    private BoardController monJeu;

    @Given("^I have two players$")
    public void CreateTwoPlayers() throws Exception{
        monJeu = new BoardController();
        p1 = monJeu.getPlayer1();
        p2 = monJeu.getPlayer2();
    }

    @Then("^each players have (\\d+) cards$")
    public void TestNumberOfCards(int nbCards) throws Exception{
        assertEquals("p1 should have "+nbCards, nbCards,p1.getHand().size());
        assertEquals("p2 should have "+nbCards,nbCards,p2.getHand().size());
    }
    @When("^I Create a new Game$")
    public void CreateGame() throws Exception{
        monJeu.StartGame();
    }
    @Then("^each players have (\\d+) cards in its handUi")
    public void TestCardsUi(int nbCards) throws Exception {
        assertEquals("p1 should have "+nbCards+" in its handUi", nbCards,monJeu.getHandUiP1().getChildren().size());
    }

}
