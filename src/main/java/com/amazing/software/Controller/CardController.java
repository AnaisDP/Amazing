package com.amazing.software.Controller;

import com.amazing.software.Model.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Objects;

public class CardController extends Pane {
    BoardController parent;
    public
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
        this.pane = fxmlLoader.load();
        initCard();
    }

    private void initCard() {
        this.pane.setEffect(new DropShadow(20, Color.WHITE));
        this.pane.setStyle("-fx-border-color: black;"); //Initialize card here
        this.pane.setStyle("-fx-border-radius : ");
        if (Objects.equals("Elf", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: green;");
        } else if (Objects.equals("Dryad", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: white;");
        } else if (Objects.equals("Gobelin", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: blue;");
        } else if (Objects.equals("Gnome", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: orange;");
        } else if (Objects.equals("Korrigan", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: red;");
        } else if (Objects.equals("Dryad", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: yellow;");
        } else if (Objects.equals("Troll", this.card.getRace().getName())) {
            this.pane.setStyle("-fx-background-color: purple;");
        }
    }
}