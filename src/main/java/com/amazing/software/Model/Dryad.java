package com.amazing.software.Model;

public class Dryad extends Race {
    public Dryad(){
        this.name = "Dryad";
        this.power = "Stole a card in front of your opponent and add it in front of you without activating its power.";
    }
    public void Power(Joueur Joueurutilise,Joueur Joueurvictime,int indexCardStolen){
        Carte carte =Joueurvictime.getTerrain().get(indexCardStolen);
        Joueurutilise.getTerrain().add(carte);
        Joueurvictime.getTerrain().remove(carte);

    }
}


