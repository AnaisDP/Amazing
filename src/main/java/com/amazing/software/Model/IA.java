package com.amazing.software.Model;

import java.util.List;
import java.util.Objects;

public class IA {
    private Player self;
    private Player opponnent;
    private int possiblescore;
    private int nbofGnome;
    private int nbofGobelin;
    private int nbofElf;
    private int nbofDryad;
    private int nbofKorrigan;
    private int nbofTroll;

    public IA(Player self,Player opponnent){
        this.self=self;
        this.opponnent=opponnent;
    }
    public int getIndexOf(String name,List<Card> liste){
        int index=-1;
        for (Card card:this.self.getHand()) {
            index++;
            if(card.getRace().getName()==name){
                return index;
            }
        }
        return index;
    }
    public void initialize(List<Card> list){
        this.nbofDryad=0;
        this.nbofGnome=0;
        this.nbofTroll=0;
        this.nbofKorrigan=0;
        this.nbofGobelin=0;
        this.nbofElf=0;
        for (Card card:list) {
            if(Objects.equals("Elf",card.getRace().getName())){
                nbofElf++;
            }
            if(Objects.equals("Korrigan",card.getRace().getName())){
                nbofKorrigan++;
            }
            if(Objects.equals("Dryad",card.getRace().getName())){
                nbofDryad++;
            }
            if(Objects.equals("Troll",card.getRace().getName())){
                nbofTroll++;
            }
            if(Objects.equals("Gnome",card.getRace().getName())){
                nbofGnome++;
            }
            if(Objects.equals("Gobelin",card.getRace().getName())){
                nbofGobelin++;
            }
        }
    }
    public int makeMove(){
        initialize(this.self.getHand());
        int index=0;
        if(nbofKorrigan>0){
            return getIndexOf("Korrigan",self.getHand());
        }
        else if(nbofGobelin>0 && opponnent.getHand().size()>self.getHand().size()){
            return  getIndexOf("Gobelin",self.getHand());
        }
        else if(nbofTroll>0 && opponnent.getBoard().size()>self.getBoard().size()){
            return  getIndexOf("Troll",self.getHand());
        }
        else if(nbofGnome>0){
            return getIndexOf("Gnome",self.getHand());
        }
        return index;
    }
    public int chooseCardBoard(){
        initialize(this.self.getBoard());
        int index=0;
        if(nbofKorrigan>0){
            return getIndexOf("Korrigan",self.getHand());
        }
        else if(nbofGobelin>0 && opponnent.getHand().size()>self.getHand().size()){
            return  getIndexOf("Gobelin",self.getHand());
        }
        else if(nbofTroll>0 && opponnent.getBoard().size()+1>self.getBoard().size()){
            return  getIndexOf("Troll",self.getHand());
        }
        else if(nbofGnome>0){
            return getIndexOf("Gnome",self.getHand());
        }
        return index;
    }
}

