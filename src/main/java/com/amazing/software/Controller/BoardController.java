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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {

    //TODO assigné dans la vue
    @FXML
    private GridPane handUiP1; //Ui main du joueur 1
    @FXML
    private GridPane handUiP2; // Ui main du joueur 2
    @FXML
    private Pane pioche; //Ui pour la pioche
    @FXML
    private GridPane terrainUiP1; //Ui pour le terrain du joueur 1
    @FXML
    private GridPane terrainUiP2; //Ui pour le terrain du joueur 2
    private Joueur player1;
    private Joueur player2;
    private Jeu game;
    ///Ces variable sont bindées via les Listeners
    private ObservableList<CarteController> handP1 = FXCollections.observableArrayList(); //Bind sur handUiP1
    private ObservableList<CarteController> handP2 = FXCollections.observableArrayList(); //Bind sur handUiP2
    private ObservableList<CarteController> boardP1 = FXCollections.observableArrayList(); //Bind sur terrainUiP1
    private ObservableList<CarteController> boardP2 = FXCollections.observableArrayList(); //Bind sur terrainUiP2


    public BoardController() throws Exception{
        this.player1 = new Joueur();
        this.player2 = new Joueur();
        this.game = new Jeu(player1,player2);
    }

    public void StartGame()throws Exception{
        int count = 0;
        for(Carte carte :player1.getMain()){
            Draw(carte,player1);
        }
    }

    public void Draw(Carte carte,Joueur joueur) throws Exception{
        carte.setRetournee(Boolean.TRUE);
        URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
        fxmlLoader.setController(new CarteController(carte,this));
        Pane pane = (Pane)fxmlLoader.load();
        CarteController carteController = fxmlLoader.getController();
        carteController.initCard();
        handP1.add(carteController);
    }

    @Override
    //Cette fonction est appellé lorsque que BoardController est completement initialisé
    public void initialize(URL location, ResourceBundle resources){
        //On ajoute les listener a l'initialisation de la vue
        handP1.addListener(new ListChangeListener<CarteController>() {

            @Override
            public void onChanged(Change<? extends CarteController> c) {
                System.out.println("Change detected on" + c);
                while(c.next()){
                    System.out.println("Change from "+c.getFrom());
                    final ColumnConstraints columnConstraints = new ColumnConstraints();
                    handUiP1.getColumnConstraints().add(columnConstraints);
                    handUiP1.add(handP1.get(c.getFrom()).getPane(),c.getFrom(),0);
                }
            }
        });
        gridPaneInit();
    }

    //region InitMethods
    private void gridPaneInit(){
        //Initialisation du GridPane avec 1 ligne 1 colonne (Main vide)
        final RowConstraints rowConstraints = new RowConstraints();
        this.handUiP1.getRowConstraints().add(rowConstraints);
        final ColumnConstraints columnConstraints = new ColumnConstraints();
        this.handUiP1.getColumnConstraints().add(columnConstraints);
        this.handUiP1.setGridLinesVisible(true);
        this.handUiP1.setVgap(15);
        this.handUiP1.setHgap(15);
        this.handUiP1.setAlignment(Pos.CENTER);
    }
    //endregion

    //region Get/Set
    public Joueur getPlayer1() {
        return player1;
    }
    public Joueur getPlayer2() {
        return player2;
    }
    //endregion

    //TODO Implémenter la fonction onClick des cartes qui permettra de la poser sur le terrain
    //TODO Implémenter la fonction piocher au niveau de l'UI
}
