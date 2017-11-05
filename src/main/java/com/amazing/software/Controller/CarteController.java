package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Carte;
import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarteController {



    @FXML
    Pane pane;

    Carte carte;

    public Carte getCarte() {
        return carte;
    }

    public Pane getPane() {
        return pane;
    }

    public CarteController (Carte carte){
        this.carte = carte;

    }

    public void initCard(){
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
