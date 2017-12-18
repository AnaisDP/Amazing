package com.amazing.software;

import com.amazing.software.Controller.BoardController;
import com.amazing.software.Model.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com.amazing.software/Board.fxml"));
            loader.setController(new BoardController());
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/com.amazing.software/StyleCard.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            BoardController boardController = loader.getController();
            boardController.StartGame();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //Game game=new Game();
        launch(args);

    }

}
