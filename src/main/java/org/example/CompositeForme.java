package org.example;

import java.util.ArrayList;
import java.util.List;

public class CompositeForme implements Composite{
    String Nom;
    List<Composite> enfantForme =new ArrayList<Composite>();
    public CompositeForme(String nom) {
        this.Nom=nom;
    }

    public void addComposite(Composite composite){
        this.enfantForme.add(composite);
    }
    @Override
    public void print() {
        System.out.println(this.Nom + ":(");
        for (Composite composite : enfantForme) {
            composite.print();
        }
        System.out.println(")");
    }

    @Override
    public void move(double x , double y) {
        for (Composite composite : enfantForme) {
            composite.move(x,y);
        }
    }

    @Override
    public String return_name() {
        return this.Nom;
    }
}
