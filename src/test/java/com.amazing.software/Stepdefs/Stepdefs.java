package com.amazing.software.Stepdefs;

import com.amazing.software.Model.*;
import com.sun.javafx.scene.control.ControlAcceleratorSupport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Stack;

import static org.junit.Assert.assertEquals;


public class Stepdefs {

    private Player player1;
    private Player player2;
    private Board board;
    private Stack<Card> deck;

    @Given("^I have two players$")
    public void CreatePlayer() throws Throwable{
        player1 = new Player();
        player2 = new Player();
    }

    @Then("^they have (\\d+) cards$")
    public void NumberOfCard(int nbCard) throws Throwable{
        assertEquals("Player1 should have "+nbCard+" card",nbCard,player1.getHand().size());
        assertEquals("Player2 should have "+nbCard+" card",nbCard,player2.getHand().size());

    }

    @When("^I Distribute Cards$")
    public void LaunchGame() throws Throwable{
        board = new Board(player1,player2);
        board.DistributeCards();
    }

    @Given("^Player1 has (\\d+) cards$")
    public void Player1(int nbCard) throws Throwable{
        player1 = new Player();
        player2 = new Player();
        board = new Board(player1,player2);

        while (player1.getHand().size()< nbCard)
        {
            player1.Draw(board.getDeck());
        }

        assertEquals("Player1 should have "+nbCard+" card",nbCard,player1.getHand().size());
    }

    @Given("^Player2 has (\\d+) cards$")
    public void Player2(int nbCard) throws Throwable{
        while (player2.getHand().size()< nbCard)
        {
            player2.Draw(board.getDeck());
        }
        assertEquals("Player2 should have "+nbCard+" card",nbCard,player2.getHand().size());
    }

    @Given("^Player1 has a gobelin$")
    public void SetGobelin() throws Throwable{
        Race gob = new Gobelin();
        Card gobelin = new Card(gob);
        player1.getHand().add(gobelin);
    }

    @When("^Player1 use gobelin$")
    public void UseGobelin() throws Throwable{

        for (Card c:player1.getHand()) {
            if (c.getRace() instanceof Gobelin)
            {
                c.getRace().Power(player1,player2,board.getDeck(),0);

            }
        }
    }

    @Given("^Player1 has a Gnome$")
    public  void  SetGnome() throws Throwable{
        Race gno = new Gnome();
        Card gnome = new Card(gno);
        player1.getHand().add(gnome);
    }

    @When("^Player1 use Gnome$")
    public void UseGnome() throws Throwable {
        for (Card c:player1.getHand()) {
            if (c.getRace() instanceof Gnome)
            {
                c.getRace().Power(player1, player2, board.getDeck(),0);

            }
        }
    }
}
