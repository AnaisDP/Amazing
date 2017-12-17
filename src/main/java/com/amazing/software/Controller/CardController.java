package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Card;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CardController extends Pane {

    BoardController parent;

    @FXML
    Pane pane;

    Card card;

    public Card getCard() {
        return card;
    }

    public Pane getPane() {
        return pane;
    }

    public CardController(Card card,BoardController boardController) throws Exception {
        this.card = card;
        URL fxmlUrl = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(this);
        this.pane = (Pane) fxmlLoader.load();
        this.parent = boardController;
        initCard();
    }
    public Card WaitCard(List<Card> Place){
        Card cardSelected=null;
        return cardSelected;
    }
    private void initCard() {
        this.pane.setEffect(new DropShadow(20, Color.WHITE));
        this.pane.setStyle("-fx-border-color: black;"); //Initialize card here
        this.pane.setStyle("-fx-border-radius : ");

            if ("Elf".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: green;");
            } else if ("Dryad".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: white;");
            } else if ("Gobelin".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: blue;");
            } else if ("Gnome".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: orange;");
            } else if ("Korrigan".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: red;");
            } else if ("Dryad".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: yellow;");
            } else if ("Troll".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-color: purple;");
            }

            this.pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node node = pane.getParent();
                    String nameParentUI = node.getId();
                    System.out.println("Parent : " + nameParentUI);
                    System.out.println("Card clicked :"+card.toString());
                    System.out.println("Joueur played :"+parent.getPlayer1().toString());
                    String previous;
                    switch (nameParentUI) {
                        case "handUiP1":
                            parent.getPlayer1().Play(card);
                            card.getRace().Power(parent.getPlayer1(), parent.getPlayer2(), parent.getDeck(), null);
                            try {
                                parent.HandUpdate();
                                parent.UpdateBoard();
                                parent.PopulationUpdate();
                                parent.ScoreUpdate();
                                parent.UpdateGameMaster("Player 1 has played a "+card.getRace().getName());


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                             break;
                    }
                    //parent.getPlayer1().Play(card);
                    //parent.updateBoard();
                }
            });
        }
    }