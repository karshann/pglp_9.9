package org.example;

public class CommandeShow implements Commande{
    Interpreteur interpreteur;
    public CommandeShow(Interpreteur i) {
        this.interpreteur=i;
    }

    @Override
    public void init(String S) {
    }

    @Override
    public void execute() {
        System.out.println("Dessin n° "+this.interpreteur.dessin + ":" + this.interpreteur.nomdessin.get(this.interpreteur.dessin));
        for (Composite composite:this.interpreteur.compositeListe){
            composite.print();
        }
    }

    @Override
    public void print() {

    }
}
