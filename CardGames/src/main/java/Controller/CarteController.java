package Controller;

import Model.Carte;
import javafx.application.Application;
import javafx.stage.Stage;

public class CarteController extends Application {
    Carte carte;

    public CarteController (Carte carte){
        this.carte = carte;
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
