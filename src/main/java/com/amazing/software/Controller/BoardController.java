package com.amazing.software.Controller;

import com.amazing.software.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {

    //TODO assigné dans la vue
    @FXML
    private GridPane handUiP1; //Ui handPlayer du joueur 1
    @FXML
    private GridPane handUiP2; // Ui handPlayer du joueur 2
    @FXML
    private Pane pioche; //Ui pour la pioche
    @FXML
    private GridPane terrainUiP1; //Ui pour le terrain du joueur 1
    @FXML
    private GridPane terrainUiP2; //Ui pour le terrain du joueur 2
    private Player player1;
    private Player player2;

    private Stack<Carte> deck;
    //private Jeu game;
    ///Ces variable sont bindées via les Listeners
    private ObservableList<CarteController> handP1 = FXCollections.observableArrayList(); //Bind sur handUiP1
    private ObservableList<CarteController> handP2 = FXCollections.observableArrayList(); //Bind sur handUiP2
    private ObservableList<CarteController> boardP1 = FXCollections.observableArrayList(); //Bind sur terrainUiP1
    private ObservableList<CarteController> boardP2 = FXCollections.observableArrayList(); //Bind sur terrainUiP2


    public BoardController() throws Exception{
        this.player1 = new Player();
        this.player2 = new Player();
        //this.game = new Jeu(player1,player2);
    }

    private void GenerateDeck(){
        //TODO
        List<Carte> list = new ArrayList<Carte>();
        list = GenerateADeck();
        java.util.Collections.shuffle(list);
        this.deck = (Stack)list;
    }

    private List<Carte> GenerateADeck(){
        List<Carte> myList = new ArrayList<Carte>();
        //Dryad
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Dryad());
            myList.add(card);
        }
        //Elf
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Elf());
            myList.add(card);
        }
        //Gnome
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Gnome());
            myList.add(card);
        }
        //Gobelin
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Gobelin());
            myList.add(card);
        }
        //Korrigan
        for(int i = 0; i < 7 ; i++){
            Carte card = new Carte(new Korrigan());
            myList.add(card);
        }
        //Troll
        for(int i = 0; i < 7 ; i++) {
            Carte card = new Carte(new Troll());
            myList.add(card);
        }
        return myList;
    }

    public  void Distribute(Player player){
        while(player.getHandPlayer().size() < 5){
            player.Draw(this.deck);
        }
    }
    public void StartGame()throws Exception{
        GenerateDeck();
        Distribute(player1);
        Distribute(player2);
    }

    /*public void Draw(Carte carte,Player player) throws Exception{
        carte.setRetournee(Boolean.TRUE);
        URL fxmlURL = getClass().getResource("/com.amazing.software/Card.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
        fxmlLoader.setController(new CarteController(carte,this));
        Pane pane = (Pane)fxmlLoader.load();
        CarteController carteController = fxmlLoader.getController();
        carteController.initCard();
        handP1.add(carteController);
    }*/

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
        //Initialisation du GridPane avec 1 ligne 1 colonne (handPlayer vide)
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
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    //endregion

    //TODO Implémenter la fonction onClick des cartes qui permettra de la poser sur le terrain
    //TODO Implémenter la fonction piocher au niveau de l'UI
}
