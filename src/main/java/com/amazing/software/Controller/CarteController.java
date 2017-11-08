package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Carte;
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
        this.pane.setEffect(new DropShadow(20,Color.WHITE));
        this.pane.setStyle("-fx-border-color: black;"); //Initialize card here
        this.pane.setStyle("-fx-border-radius : ");
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

       /*this.pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println(carte.getRace());
                try {
                    System.out.println("Clicked on "+this.toString());
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        */
    }

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
