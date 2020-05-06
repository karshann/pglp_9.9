package org.example;

public class CommandeMove implements Commande{
    Interpreteur I;
    String[] val;
    String name;
    Composite c;


    public CommandeMove(Interpreteur I){
        this.I=I;
    }

    @Override
    public void init(String S){
        String tmp =S.replace("move","");
        tmp=tmp.replaceAll("\\(" ,"");
        tmp=tmp.replaceAll("\\)","");
        val=tmp.split(",");
        name=val[0];
    }


    @Override
    public void execute() {
        double x=0;
        double y=0;
        try{
            x=Double.parseDouble(val[1]);
            y=Double.parseDouble(val[2]);
            c=I.getComposite(name);
            c.move(x,y);
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }

    }
    @Override
    public void print() {
        c.print();
    }
}
