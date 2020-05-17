package org.example;

import java.util.List;

public class CommandeSave implements Commande{
    String object;
    Interpreteur I;
    CommandeSave(Interpreteur i){
        this.I=i;
    }
    @Override
    public void init(String S) {
        this.object=S.replace("save","");
        this.object=this.object.replace("(","");
        this.object=this.object.replace(")","");
    }

    @Override
    public void execute() throws  NullPointerException{
        List<Composite> c=this.I.compositeListe;
        DAO D;
        D=new CompositeFormeDAO(this.I.dessin);
        D.deletedessin(this.I.dessin);
        D=new RectangleDAO(this.I.dessin);
        D.deletedessin(this.I.dessin);
        D=new CarreDAO(this.I.dessin);
        D.deletedessin(this.I.dessin);
        D=new CercleDAO(this.I.dessin);
        D.deletedessin(this.I.dessin);
        D=new TriangleDAO(this.I.dessin);
        D.deletedessin(this.I.dessin);
        for (Composite composite:c) {
            if (composite instanceof CompositeForme){
                D=new CompositeFormeDAO(this.I.dessin);
                D.create((CompositeForme)composite);
            }
            else if (composite instanceof Carre){
                D=new CarreDAO(this.I.dessin);
                D.create((Carre)composite);
            }
            else if (composite instanceof Cercle){
                D=new CercleDAO(this.I.dessin);
                D.create((Cercle)composite);

            }
            else if (composite instanceof Triangle){
                D=new TriangleDAO(this.I.dessin);
                D.create((Triangle)composite);
            }
            else if (composite instanceof Rectangle) {
                D=new RectangleDAO(this.I.dessin);
                D.create((Rectangle)composite);
            }
        }
    }

    @Override
    public void print() {
        System.out.println("La figure a bien été ajouter");
    }
}
