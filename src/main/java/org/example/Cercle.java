package org.example;

public class Cercle implements Forme{
    String nom;
    Point centre;
    double rayon;

    public Cercle(String Nom , double x , double y , double rayon){
        this.centre=new Point(x,y);
        this.nom=Nom;
        this.rayon=rayon;
    }

    @Override
    public void move(double x, double y) {
        this.centre.sommePoint(x,y);
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "nom='" + nom + '\'' +
                ", centre=" + centre.toString() +
                ", rayon=" + rayon +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
