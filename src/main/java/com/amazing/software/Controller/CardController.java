package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Card;
import com.amazing.software.Model.IA;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
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

    @FXML
    private Pane paneNbCard;

    @FXML
    private Label labelNbCard;

    Card card;

    int index = 0;
    int indexcard;
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
        this.labelNbCard.setText("0");
        this.paneNbCard.setVisible(false);
        initCard();
    }

    private void initCard() throws Exception {
        this.pane.setEffect(new DropShadow(20, Color.WHITE));
        this.pane.setStyle("-fx-border-color: black;"); //Initialize card here
        this.pane.setStyle("-fx-border-radius : ");

            if ("Elf".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-image: url(/com.amazing.software/elf.jpg);");
            } else if ("Dryad".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-image: url(/com.amazing.software/dryad.jpg);");
            } else if ("Gobelin".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-image: url(/com.amazing.software/goblin.jpg);");
            } else if ("Gnome".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-image: url(/com.amazing.software/gnome.jpg);");
            } else if ("Korrigan".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-image: url(/com.amazing.software/korrigan.jpg);");
            } else if ("Troll".equals(this.card.getRace().getName())) {
                this.pane.setStyle("-fx-background-image: url(/com.amazing.software/troll.jpg);");
            }

            this.pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node node = pane.getParent();
                    String nameParentUI = node.getId();
                    System.out.println("Parent : " + nameParentUI);
                    System.out.println("Card clicked :"+card.toString());
                    switch (nameParentUI) {
                        case "handUiP1":
                            if(!parent.getWaitingForCard()) {
                                System.out.println("Joueur played :" + parent.getPlayer1().toString());
                                parent.getPlayer1().Play(card);
                                if ("Elf".equals(card.getRace().getName())) {
                                    try {
                                        try {
                                            parent.HandUpdate();
                                            parent.UpdateBoard();
                                            parent.PopulationUpdate();
                                            parent.ScoreUpdate();
                                            parent.UpdateGameMaster("You must pick a card in your area.");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        parent.WaitingForCard(card, true);
                                        //card.getRace().Power(parent.getPlayer1(), parent.getPlayer2(), parent.getDeck(), parent.getPlayer1().getBoard().get(index));
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } else if("Dryad".equals(card.getRace().getName())){
                                    try {
                                        parent.HandUpdate();
                                        parent.UpdateBoard();
                                        parent.PopulationUpdate();
                                        parent.ScoreUpdate();
                                        parent.UpdateGameMaster("You must pick a card in enemie area.");
                                        } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                    parent.WaitingForCard2(card,true);
                                }else {
                                    card.getRace().Power(parent.getPlayer1(), parent.getPlayer2(), parent.getDeck(), null);
                                    try {
                                        parent.HandUpdate();
                                        parent.UpdateBoard();
                                        parent.PopulationUpdate();
                                        parent.ScoreUpdate();
                                        parent.UpdateGameMaster("Player 1 has played a " + card.getRace().getName());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            else{
                                parent.UpdateGameMaster("You must pick a card in your area");
                            }
                            labelNbCard.setVisible(true);
                             break;

                        case "boardUiP1":
                            if(parent.getWaitingForCard()){
                                parent.getTempCard().getRace().Power(parent.getPlayer1(),parent.getPlayer2(),parent.getDeck(),card);
                                parent.setWaitingForCard(false);
                                try {
                                    parent.HandUpdate();
                                    parent.UpdateBoard();
                                    parent.PopulationUpdate();
                                    parent.ScoreUpdate();
                                    parent.UpdateGameMaster("Player 1 has picked a "+card.getRace().getName());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                        case "boardUiP2":
                            if(parent.getWaitingForCard2()){
                                parent.getTempCard().getRace().Power(parent.getPlayer1(),parent.getPlayer2(),parent.getDeck(),card);
                                parent.setWaitingForCard2(false);
                                try {
                                    parent.HandUpdate();
                                    parent.UpdateBoard();
                                    parent.PopulationUpdate();
                                    parent.ScoreUpdate();
                                    parent.UpdateGameMaster("Player 1 has picked a "+card.getRace().getName());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                    }
                    if(!parent.getWaitingForCard() || !parent.getWaitingForCard2()){
                        try {
                            parent.turnIA();
                            parent.HandUpdate();
                            parent.UpdateBoard();
                            parent.PopulationUpdate();
                            parent.ScoreUpdate();
                            parent.UpdateGameMaster("Player 1 has picked a "+card.getRace().getName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //parent.getPlayer1().Play(card);
                    //parent.updateBoard();
                }
            });
        }

    }