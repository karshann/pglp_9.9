package org.example;

import java.util.HashMap;
import java.util.Map;

public class DrawingTUI {
    /**
     *
     */
    Interpreteur I;
    /**
     *
     */
    private final Map<String, Commande> commandes;

    /**
     *
     */
    public DrawingTUI() {
        this.I = new Interpreteur();
        this.commandes = new HashMap<>();
    }

    /**
     *
     * @param nom
     * @param Commande
     */
    public void ajouterCommande(String nom, Commande Commande) {
        this.commandes.put(nom, Commande);
    }

    /**
     *
     */
    public void init() {
        this.ajouterCommande("=",new Commandeegale(I));
        this.ajouterCommande("move",new CommandeMove(I));
        this.ajouterCommande("groupe",new Commandegroupe(I));
        this.ajouterCommande("addgrp",new Commandeaddgroupe(I));
        this.ajouterCommande("quit",new CommandeQuit());
        this.ajouterCommande("save",new CommandeSave(I));
        this.ajouterCommande("new",new Commandenew(I));
        this.ajouterCommande("show",new CommandeShow(I));
        this.ajouterCommande("load",new CommandeLoad(I));
        this.ajouterCommande("delete",new CommandeDelete(I));
    }

    /**
     *
     * @param S
     * @return Commande
     */
    public Commande nextCommande(String S) {
        boolean bool=false;
        for (String key:commandes.keySet()) {
            if (S.contains(key)) {
                Commande commande = this.commandes.get(key);
                commande.init(S);
                return commande;
            }
        }
        System.err.println("La commande n'existe pas");
        return null;
    }
}
