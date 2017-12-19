package com.amazing.software.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private Button playButton;

    public MenuController() throws Exception {

    }

    public void Play(ActionEvent e) throws Exception {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.amazing.software/Defeat.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage gameStage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/com.amazing.software/Style.css").toExternalForm());
        gameStage.setScene(scene);
        gameStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.amazing.software/Victory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage gameStage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/com.amazing.software/Style.css").toExternalForm());
        gameStage.setScene(scene);
        gameStage.show();*/


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.amazing.software/Board.fxml"));
        loader.setController(new BoardController());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage gameStage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/com.amazing.software/StyleCard.css").toExternalForm());
        gameStage.setScene(scene);
        gameStage.show();
        BoardController boardController = loader.getController();
        boardController.StartGame();
    }



}