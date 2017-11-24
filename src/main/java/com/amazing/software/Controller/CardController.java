package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Card;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;

public class CardController extends Pane {

    @FXML
    Pane pane;

    Card card;

    public Card getCard() {
        return card;
    }

    public Pane getPane() {
        return pane;
    }

    public CardController(Card card) throws Exception {
        this.card = card;
        URL fxmlUrl = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(this);
        this.pane = (Pane) fxmlLoader.load();
        initCard();
    }

    private void initCard() {
        this.pane.setEffect(new DropShadow(20, Color.WHITE));
        this.pane.setStyle("-fx-border-color: black;"); //Initialize card here
        this.pane.setStyle("-fx-border-radius : ");
        if (this.card.getRace().getName() == "Elf") {
            this.pane.setStyle("-fx-background-color: green;");
        } else if (this.card.getRace().getName() == "Dryad") {
            this.pane.setStyle("-fx-background-color: white;");
        } else if (this.card.getRace().getName() == "Gobelin") {
            this.pane.setStyle("-fx-background-color: blue;");
        } else if (this.card.getRace().getName() == "Gnome") {
            this.pane.setStyle("-fx-background-color: orange;");
        } else if (this.card.getRace().getName() == "Korrigan") {
            this.pane.setStyle("-fx-background-color: red;");
        } else if (this.card.getRace().getName() == "Dryad") {
            this.pane.setStyle("-fx-background-color: yellow;");
        } else if (this.card.getRace().getName() == "Troll") {
            this.pane.setStyle("-fx-background-color: purple;");
        }
    }
}