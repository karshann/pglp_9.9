package org.example;

import java.util.ArrayList;
import java.util.List;

public class CompositeForme implements Composite{
    String Nom;
    List<Composite> enfantForme =new ArrayList<Composite>();
    public CompositeForme(String nom) {
        this.Nom=nom;
    }

    public List<Composite> getEnfantForme() {
        return enfantForme;
    }

    public boolean verif_nom(String Nom){
        CompositeForme cf;
        for (Composite comp:this.enfantForme) {
            if(comp.return_name().equals(Nom)){
                return false;
            }
            if (comp instanceof CompositeForme){
                cf= ((CompositeForme) comp);
                return cf.verif_nom(Nom);
            }
        }
        return true;
    }
    public Composite getComposite(String Nom){
        CompositeForme cf;
        for (Composite comp:this.enfantForme) {
            if(comp.return_name().equals(Nom)){
                return comp;
            }
            if (comp instanceof CompositeForme){
                cf= ((CompositeForme) comp);
                return cf.getComposite(Nom);
            }
        }
        return null;
    }
    public void addComposite(Composite composite){
        this.enfantForme.add(composite);
    }

    public void cremove(Composite composite){
        for (Composite composite1:this.enfantForme) {
            if (composite1.return_name().equals(composite.return_name())){
                this.enfantForme.remove(composite);
                break;
            }
            if (composite1 instanceof CompositeForme){
                ((CompositeForme) composite1).cremove(composite);
            }
        }
    }
    @Override
    public void print() {
        System.out.println(this.Nom + ":(");
        for (Composite composite : enfantForme) {
            composite.print();
        }
        System.out.println(")");
    }

    /**
     *
     * @param x
     * @param y
     */
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
