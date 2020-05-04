package org.example;

public class Carre implements Forme{
    String Nom;
    Point p1;
    double cote;
    public Carre(String nom ,double cote , int x , int y){
        this.Nom=nom;
        this.p1=new Point(x,y);
        this.cote=cote;

    }

    @Override
    public void move(double x, double y) {
        this.p1.sommePoint(x,y);
    }

    @Override
    public String toString() {
        return "Carre{" +
                "Nom='" + Nom + '\'' +
                ", p1=" + p1.toString() +
                ", cote=" + cote +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
