package org.example;

public class CommandeMove implements Commande{
    Interpreteur I;


    public CommandeMove(Interpreteur I){
        this.I=I;
    }

    @Override
    public void execute(String S) {
        String suite =S.replace("move","");
        suite=suite.replaceAll("\\(" ,"");
        suite=suite.replaceAll("\\)","");
        String name ;
        double x=0;
        double y=0;
        String[] tab=suite.split(",");
        name=tab[0];
        try{
            x=Double.parseDouble(tab[1]);
            y=Double.parseDouble(tab[2]);
            Composite composite=I.getComposite(name);
            composite.move(x,y);
            I.modif_composite(composite);
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }

    }
}
