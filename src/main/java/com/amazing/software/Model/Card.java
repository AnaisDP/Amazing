package com.amazing.software.Model;

public class Card {
    private Boolean retournee = false;
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

    public Card(Race race){
        this.race = race;
    }

    public String ToString(){
        return "La race de cette Card est " + race.name;
    }
}
