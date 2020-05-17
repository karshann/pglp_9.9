package org.example;

import java.util.ArrayList;

public class Commandenew implements Commande {
    String dessin;
    String nom;
    Interpreteur I;
    public Commandenew(Interpreteur i) {
        this.I=i;
    }

    @Override
    public void init(String S) {
        dessin=S.replace("new","");
        dessin=dessin.replace("(","").replace(")","");
        String [] val= dessin.split(",");
        dessin=val[0];
        nom=val[1];
    }

    @Override
    public void execute() {
        int i =Integer.parseInt(dessin);
        this.I.nomdessin.add(i,nom);
        this.I.dessin=Integer.parseInt(dessin);
        this.I.set_dessin();
    }
    @Override
    public void print() {
        System.out.println(dessin+ ":"+ nom);
    }
}
