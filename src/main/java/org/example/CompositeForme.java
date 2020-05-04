package org.example;

import java.util.ArrayList;
import java.util.List;

public class CompositeForme implements Composite{
    String Nom;
    List<Composite> enfantForme =new ArrayList<Composite>();
    public CompositeForme(String nom) {
        this.Nom=nom;
    }
    @Override
    public void print() {
        for (Composite composite : enfantForme) {
            composite.print();
        }
    }

    @Override
    public void move(double x , double y) {
        for (Composite composite : enfantForme) {
            composite.move(x,y);
        }
    }

}
