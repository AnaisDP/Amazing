package Model;

import java.util.List;

public class MainDuJoueur {
    private List<Carte> carteList;

    public MainDuJoueur(List<Carte> carteList){
        this.carteList = carteList;
    }

    public void Show(){
        for (Carte carte : carteList){
            carte.setRetournee(true);
        }
    }
}
