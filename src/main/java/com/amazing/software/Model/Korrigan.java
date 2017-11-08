package com.amazing.software.Model;
public class Korrigan extends Race {


    public Korrigan() {
        this.name = "Korrigan";
        this.power = "Draw 2 random cards within your opponent hand";
    }
    public void Power(Joueur Joueurutilise,Joueur Joueurvictime){
        int rand= (int) (Math.random() * ( Joueurvictime.getMain().size() - 0 ));
        Joueurutilise.StealCard(rand,Joueurvictime);
    }


}
