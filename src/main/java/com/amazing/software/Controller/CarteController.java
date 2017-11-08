package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Carte;
import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarteController extends Pane {

    @FXML
    Pane pane;

    Carte carte;

    public Carte getCarte() {
        return carte;
    }

    public Pane getPane() {
        return pane;
    }

    public CarteController(Carte carte) throws Exception{
        this.carte = carte;
        URL fxmlUrl = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(this);
        this.pane = (Pane)fxmlLoader.load();
        initCard();
    }

    private void initCard() {
        //Initialize card here
        if (this.carte.getRace().getName() == "Elf") {
            this.pane.setStyle("-fx-background-color: green;");
        } else if (this.carte.getRace().getName() == "Dryad") {
            this.pane.setStyle("-fx-background-color: white;");
        } else if (this.carte.getRace().getName() == "Gobelin") {
            this.pane.setStyle("-fx-background-color: blue;");
        } else if (this.carte.getRace().getName() == "Gnome") {
            this.pane.setStyle("-fx-background-color: orange;");
        } else if (this.carte.getRace().getName() == "Korrigan") {
            this.pane.setStyle("-fx-background-color: red;");
        } else if (this.carte.getRace().getName() == "Dryad") {
            this.pane.setStyle("-fx-background-color: yellow;");
        } else if (this.carte.getRace().getName() == "Troll") {
            this.pane.setStyle("-fx-background-color: purple;");
        }

 /*       this.pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println(carte.getRace());
                try {
                    boardController.Draw(carte, boardController.getPlayer1());
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }
    */

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        //Initialize card here
        if(this.carte.getRetournee() == false){
            this.pane.setStyle("-fx-background-color: black;");
        }
        else if (this.carte.getRace().getName() == "Elf"){
            this.pane.setStyle("-fx-background-color: green;");
        }
        else if (this.carte.getRace().getName() == "Dryad"){
            this.pane.setStyle("-fx-background-color: white;");
        }
        else if (this.carte.getRace().getName() == "Gobelin"){
            this.pane.setStyle("-fx-background-color: blue;");
        }
        else if (this.carte.getRace().getName() == "Gnome"){
            this.pane.setStyle("-fx-background-color: orange;");
        }
        else if (this.carte.getRace().getName() == "Korrigan"){
            this.pane.setStyle("-fx-background-color: red;");
        }
        else if (this.carte.getRace().getName() == "Dryad"){
            this.pane.setStyle("-fx-background-color: yellow;");
        }
        else if (this.carte.getRace().getName() == "Troll"){
            this.pane.setStyle("-fx-background-color: purple;");
        }
    }*/


    }
}
