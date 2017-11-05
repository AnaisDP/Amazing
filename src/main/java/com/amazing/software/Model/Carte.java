package com.amazing.software.Model;

public class Carte {
    private Boolean retournee = true;
    private Race race;

    public Race getRace() {
        return race;
    }

    public Boolean getRetournee() {
        return retournee;
    }

    public void setRetournee(Boolean retournee) {
        this.retournee = retournee;
    }

    public Carte(Race race){
        this.race = race;
    }

    public String ToString(){
        return "La race de cette carte est " + race.name;
    }
}
