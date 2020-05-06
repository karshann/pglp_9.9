package org.example;

public class Commandeaddgroupe implements Commande {
    Interpreteur I;
    String nameG;
    String nameF;
    CompositeForme c;


    Commandeaddgroupe(Interpreteur I) {
        this.I = I;
    }

    @Override
    public void init(String S){
        String suite =S.replace("addgrp","");
        suite=suite.replaceAll("\\(" ,"");
        suite=suite.replaceAll("\\)","");
        String[] val=suite.split(",");
        if (val.length>2) throw new NumberFormatException();
        nameG=val[0];
        nameF=val[1];
    }
    @Override
    public void execute() {
        if(this.I.getComposite(nameG)instanceof CompositeForme) {
            c= (CompositeForme)this.I.getComposite(nameG);
            c.addComposite(this.I.getComposite(nameF));

        }
        else{
            System.err.println("Le premier argument n'est pas un groupe");
        }
    }

    @Override
    public void print() {
        c.print();
    }
}
