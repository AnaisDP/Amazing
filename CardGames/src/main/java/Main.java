import Controller.BoardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Board.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,650,450);
            primaryStage.setScene(scene);
            primaryStage.show();

            BoardController myController = loader.getController();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
