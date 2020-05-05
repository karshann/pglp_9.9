package org.example;

public class Commandeegale implements Commande{
    Interpreteur I;

    Commandeegale(Interpreteur I) {
        this.I=I;
    }
    @Override
    public void execute(String S) {

       String name = S.substring(0,S.indexOf("=")).toLowerCase();
       name.replace(" " , "");
       String type= S.substring(S.indexOf("=")+1,S.indexOf("("));
       String suite = S.substring(S.indexOf("(")+1,S.length()-1 );
       suite=suite.replace("(", "");
       suite=suite.replace(")","");
        String[] val=suite.split(",");
       if (type.equals("cercle")){
           try{
               if (val.length>3) System.out.println("trop drargument");
               else
               {
                   double x=Double.parseDouble(val[0]);
                   double y=Double.parseDouble(val[1]);
                   double rayon = Double.parseDouble(val[2]);
                   this.I.ajoutListe(new Cercle(name, x, y , rayon));

               }

           }
           catch(IllegalArgumentException e){
               e.printStackTrace();
           }

       }
       else if (type.equals("rectangle")) {
           try{
               if (val.length>4) System.out.println("trop drargument");
               else{
                   double x1=Double.parseDouble(val[0]);
                   double y1=Double.parseDouble(val[1]);
                   double x2=Double.parseDouble(val[2]);
                   double y2=Double.parseDouble(val[3]);
                   this.I.ajoutListe(new Rectangle(name, x1, y2 ,x2,y2));
               }


           }
           catch(IllegalArgumentException e){
               e.printStackTrace();
           }

       }
       else if (type.equals("triangle")) {
           if(val.length>6) System.out.println("trop drargument");
           else
           {
               double x1=Double.parseDouble(val[0]);
               double y1=Double.parseDouble(val[1]);
               double x2=Double.parseDouble(val[2]);
               double y2=Double.parseDouble(val[3]);
               double x3=Double.parseDouble(val[4]);
               double y3=Double.parseDouble(val[5]);
               this.I.ajoutListe(new Triangle(name, x1, y2 ,x2,y2, x3 , y3));
           }


       }
       else if (type.equals("carre")) {
           if (val.length > 3) System.out.println("trop drargument");
           else {
               double x1 = Double.parseDouble(val[0]);
               double y1 = Double.parseDouble(val[1]);
               double cote = Double.parseDouble(val[2]);
               this.I.ajoutListe(new Carre(name, x1, y1, cote));
           }
       }

    }
}
