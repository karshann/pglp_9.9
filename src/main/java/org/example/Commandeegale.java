package org.example;

public class Commandeegale implements Commande{
    Interpreteur I;
    String name;
    String[] val;
    String type;
    Composite c;

    Commandeegale(Interpreteur I) {
        this.I=I;
    }
    @Override
    public void init(String S){
        this.name = S.substring(0,S.indexOf("=")).toLowerCase();
        name.replace(" " , "");
        this.type= S.substring(S.indexOf("=")+1,S.indexOf("("));
        String suite = S.substring(S.indexOf("(")+1,S.length()-1 );
        suite=suite.replace("(", "");
        suite=suite.replace(")","");
        val=suite.split(",");
    }
    @Override
    public void execute() {
        if(this.I.verificationnom(name)){

            if (type.equals("cercle")){
                if (val.length!=3) System.err.println("Le format n'est pas respecté pour faire un cercle");
                else
                {
                    double x=Double.parseDouble(val[0]);
                    double y=Double.parseDouble(val[1]);
                    double rayon = Double.parseDouble(val[2]);
                    this.I.ajoutListe(c=new Cercle(name, x, y , rayon));

                }
            }
            else if (type.equals("rectangle")) {
                if (val.length!=4)System.err.println("Le format n'est pas respecté pour faire un rectangle");
                else{
                    double x1=Double.parseDouble(val[0]);
                    double y1=Double.parseDouble(val[1]);
                    double x2=Double.parseDouble(val[2]);
                    double y2=Double.parseDouble(val[3]);
                    this.I.ajoutListe(c=new Rectangle(name, x1, y2 ,x2,y2));
                }
            }
            else if (type.equals("triangle")) {
                if(val.length!=6) System.err.println("Le format n'est pas respecté pour faire un triangle");
                else
                {
                    double x1=Double.parseDouble(val[0]);
                    double y1=Double.parseDouble(val[1]);
                    double x2=Double.parseDouble(val[2]);
                    double y2=Double.parseDouble(val[3]);
                    double x3=Double.parseDouble(val[4]);
                    double y3=Double.parseDouble(val[5]);
                    this.I.ajoutListe(c=new Triangle(name, x1, y2 ,x2,y2, x3 , y3));
                }


            }
            else if (type.equals("carre")) {
                if (val.length != 3) System.err.println("Le format n'est pas respecté pour faire un carre");
                else {
                    double x1 = Double.parseDouble(val[0]);
                    double y1 = Double.parseDouble(val[1]);
                    double cote = Double.parseDouble(val[2]);
                    this.I.ajoutListe(c=new Carre(name, cote, x1, y1));
                }
            }
        }
    }
    @Override
    public void print() {
        c.print();
    }
}
