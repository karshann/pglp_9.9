package org.example;
import java.util.HashMap;
import java.util.Map;

public class GestionnairedeCommande {

    private final Map<String, Commande> commandes;
    Interpreteur I;
    public GestionnairedeCommande(){
        this.commandes=new HashMap<>();
    }

    public void ajouterCommande(String nom, Commande Commande) {
        this.commandes.put(nom, Commande);
    }
    public void execCommande(String chaine , Interpreteur I)  {
        this.I=I;
        boolean bool=false;
        for (String key:commandes.keySet()) {
            if (chaine.contains(key)) {
                this.commandes.get(key).execute(chaine);
                bool=true;
            }
        }
        if (bool == false){

        }
    }
    public void init(Interpreteur I) {
        this.I = I;
        this.ajouterCommande("=",new Commandeegale(I));
        this.ajouterCommande("move",new CommandeMove(I));
    }
}
