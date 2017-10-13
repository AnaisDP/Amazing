package Model;

public class Carte {
    private Boolean faceDown;
    private Race race;

    public Carte(Race race, Boolean faceDown){
        this.race = race;
        this.faceDown = faceDown;
    }
}
