package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrawingTUI {
    Interpreteur I;
    GestionnairedeCommande Gc;
    public DrawingTUI(){
        this.I=new Interpreteur();
        this.Gc=new GestionnairedeCommande();
        this.Gc.init(I);
    }

    public void Entree(String s){
        this.Gc.execCommande(s,this.I);
        this.I.affiche_Liste();
    }
}
