package org.example;

public class Commandegroupe implements Commande{
    Interpreteur I;
    String name;
    Composite c;

    Commandegroupe(Interpreteur I){
        this.I=I;
    }

    @Override
    public void init(String S){
        String suite =S.replace("groupe","");
        suite=suite.replaceAll("\\(" ,"");
        name=suite.replaceAll("\\)","");
    }

    @Override
    public void execute() {
        if (this.I.verificationnom(name)){
            this.I.ajoutListe(c=new CompositeForme(name));
        }
    }
    @Override
    public void print() {
        c.print();
    }
}
