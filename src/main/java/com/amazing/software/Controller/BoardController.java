package com.amazing.software.Controller;

import com.amazing.software.Main;
import com.amazing.software.Model.Carte;
import com.amazing.software.Model.Jeu;
import com.amazing.software.Model.Joueur;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {


    @FXML
    private GridPane cardP1;
    @FXML
    private GridPane cardP2;
    @FXML
    private Pane pioche;
    @FXML
    private GridPane terrain;

    private Joueur player1;
    private Joueur player2;
    private Jeu game;
    private ObservableList<CarteController> handP1 = FXCollections.observableArrayList();


    public BoardController() throws Exception{
        this.player1 = new Joueur();
        this.player2 = new Joueur();
        this.game = new Jeu(player1,player2);
    }


    @FXML
    public void StartGame()throws Exception{
        int count = 0;
        for(Carte carte :player1.getMain()){
            Draw(carte,player1);
        }
    }

    ///
    public void Draw(Carte carte,Joueur joueur) throws Exception{
        carte.setRetournee(Boolean.TRUE);
        URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
        fxmlLoader.setController(new CarteController(carte));
        Pane pane = (Pane)fxmlLoader.load();
        CarteController carteController = fxmlLoader.getController();
        carteController.initCard();
        handP1.add(carteController);
    }

    private void Poser(CarteController carteController) throws Exception{
        URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
        fxmlLoader.setController(new CarteController(carteController.getCarte()));
        Pane pane = fxmlLoader.load();
        //TODO

    }

    private void InitMouseClick(){
        this.cardP1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                //Donne la position du click sur le gridPane
                System.out.println(event.getTarget());

            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //On ajoute les listener a l'initialisation de la vue
        handP1.addListener(new ListChangeListener<CarteController>() {
            @Override
            public void onChanged(Change<? extends CarteController> c) {
                System.out.println("Change detected on" + c);
                while(c.next()){
                    System.out.println("Change from "+c.getFrom());
                    final ColumnConstraints columnConstraints = new ColumnConstraints();
                    cardP1.getColumnConstraints().add(columnConstraints);
                    cardP1.add(handP1.get(c.getFrom()).getPane(),c.getFrom(),0);
                }
            }
        });


        //Initialisation du GridPane avec 1 ligne 1 colonne (Main vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.cardP1.getRowConstraints().add(rowConstraints);
        final ColumnConstraints columnConstraints = new ColumnConstraints();
        this.cardP1.getColumnConstraints().add(columnConstraints);
        this.cardP1.setGridLinesVisible(true);
        this.cardP1.setVgap(15);
        this.cardP1.setHgap(15);
        InitMouseClick();
    }

    //TODO Implémenter la fonction onClick des cartes qui permettra de la poser sur le terrain
    //TODO Implémenter la fonction piocher au niveau de l'UI
}
