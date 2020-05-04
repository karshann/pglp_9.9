package org.example;


public class Rectangle implements Forme{
    String nom;
    Point p1;
    Point p2;
    public Rectangle(String nom , double x1 , double y1 , double x2 , double y2){
        this.p1=new Point(x1,y1);
        this.p2=new Point(x2,y2);
        this.nom = nom;
    }

    @Override
    public void move(double x, double y) {
        this.p1.sommePoint(x,y);
        this.p2.sommePoint(x,y);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "nom='" + nom + '\'' +
                ", p1=" + p1.toString() +
                ", p2=" + p2.toString() +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
