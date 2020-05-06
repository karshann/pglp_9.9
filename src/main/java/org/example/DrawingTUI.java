package org.example;

import java.util.HashMap;
import java.util.Map;

public class DrawingTUI {
    Interpreteur I;
    private final Map<String, Commande> commandes;
    public DrawingTUI(){
        this.I=new Interpreteur();
        this.commandes=new HashMap<>();
    }
    public void ajouterCommande(String nom, Commande Commande) {
        this.commandes.put(nom, Commande);
    }

    public void init() {
        this.ajouterCommande("=",new Commandeegale(I));
        this.ajouterCommande("move",new CommandeMove(I));
        this.ajouterCommande("groupe",new Commandegroupe(I));
        this.ajouterCommande("addgrp",new Commandeaddgroupe(I));
        this.ajouterCommande("quitter",new CommandeQuit());
    }
    public Commande nextCommande(String S){
        boolean bool=false;
        for (String key:commandes.keySet()) {
            if (S.contains(key)) {
                Commande commande= this.commandes.get(key);
                commande.init(S);
                return commande;
            }
        }
        System.err.println("La commande n'existe pas");
        return null;
    }
}
