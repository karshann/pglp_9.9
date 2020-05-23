package org.example;

public class CommandeDelete implements Commande {
    String Obj;
    Interpreteur interpreteur;
    CommandeDelete(Interpreteur interpreteur){
        this.interpreteur=interpreteur;
    }
    @Override
    public void init(String S) {
        Obj=S.replace("delete","").replace("(","").replace(")","");

    }

    @Override
    public void execute() {
        this.interpreteur.supressionNom(this.interpreteur.getComposite_(Obj));
    }

    @Override
    public void print() {
        this.interpreteur.affiche_Liste();
    }
}
