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
    private IA ia;
    @FXML
    Pane pane;

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
        initCard();
    }

    public int WaitForCard(Node node) throws Exception{
        indexcard=-1;
        GridPane grid = (GridPane)node;
        //Remove all listener
        for(int i = 0; i < parent.getHandUiP1().getColumnConstraints().size() ; i++) {
            parent.getHandUiP1().getChildren().get(i).setOnMouseClicked(null);
        }
        int count = 0;
        while(count < 10 || indexcard != -1){ //Player have 30sec to choose a card
        //Add listener on gridUIP2
        Card card = null;
        for(int i = 0; i < parent.getBoardUiP1().getColumnConstraints().size();i++){
            parent.getBoardUiP1().getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    for(int i =0 ; i < parent.getBoardUiP1().getColumnConstraints().size();i++){
                        if(parent.getBoardUiP1().getChildren().get(i) == parent.getBoardUiP1().getChildren().get(index)){
                            System.out.println("La carte choisit est a l'index :" + i);
                            indexcard=i;
                        }
                    }
                    System.out.println("Card waited :"+parent.getBoardUiP1().getChildren().get(index));
                }
            });
        }
            //Thread.sleep(1000);
            //System.out.println(count);
            count += 1;
        }
        for(int i = 0; i < parent.getBoardUiP1().getColumnConstraints().size() ; i++) {
            parent.getBoardUiP1().getChildren().get(i).setOnMouseClicked(null);
        }

        for(int i = 0 ; i < parent.getHandUiP1().getColumnConstraints().size();i++) {
            this.parent.getHandUiP1().getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node node = pane.getParent();
                    String nameParentUI = node.getId();
                    System.out.println("Parent : " + nameParentUI);
                    System.out.println("Card clicked :" + card.toString());
                    System.out.println("Joueur played :" + parent.getPlayer1().toString());
                    String previous;
                    switch (nameParentUI) {
                        case "handUiP1":
                            parent.getPlayer1().Play(card);
                            if ("Elf".equals(card.getRace().getName())) {
                                try {
                                    int index = WaitForCard(null);
                                    card.getRace().Power(parent.getPlayer1(), parent.getPlayer2(), parent.getDeck(), parent.getPlayer1().getBoard().get(index));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                            }else if("Dryad".equals(card.getRace().getName())){
                                try {
                                    int index = WaitForCard(null);
                                    card.getRace().Power(parent.getPlayer1(), parent.getPlayer2(), parent.getDeck(), parent.getPlayer2().getBoard().get(index));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            } else {
                                card.getRace().Power(parent.getPlayer1(), parent.getPlayer2(), parent.getDeck(), null);
                            }
                            try {
                                parent.HandUpdate();
                                parent.UpdateBoard();
                                parent.PopulationUpdate();
                                parent.ScoreUpdate();
                                parent.UpdateGameMaster("Player 1 has played a " + card.getRace().getName());
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
        //Return card clicked
        index = 0;
        return  indexcard;
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
                    }
                   int index=ia.makeMove();
                    
                    //parent.getPlayer1().Play(card);
                    //parent.updateBoard();
                }
            });
        }

    }