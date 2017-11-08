package com.amazing.software;

import com.amazing.software.Controller.BoardController;
import com.amazing.software.Controller.CarteController;
import com.amazing.software.Model.Jeu;
import com.amazing.software.Model.Joueur;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com.amazing.software/Board.fxml"));
            loader.setController(new BoardController());
            Parent root = loader.load();
            Scene scene = new Scene(root,650,450);
            primaryStage.setScene(scene);
            primaryStage.show();
            BoardController boardController = loader.getController();
            boardController.StartGame();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}