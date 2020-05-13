package org.example;

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
        Composite composite=this.I.getComposite(this.object);
        DAO D;
        if (composite instanceof CompositeForme){
            D=new CompositeFormeDAO();
            D.create((CompositeForme)composite);
        }
        else if (composite instanceof Carre){
            D=new CarreDAO();
            D.create((Carre)composite);

        }
        else if (composite instanceof Cercle){
            D=new CercleDAO();
            Cercle c =(Cercle)composite;
            c.print();
            D.create((Cercle)composite);
        }
        else if (composite instanceof Triangle){
            D=new TriangleDAO();
            D.create((Triangle)composite);
        }
        else if (composite instanceof Rectangle) {
            D=new RectangleDAO();
            D.create((Rectangle)composite);
        }
    }

    @Override
    public void print() {
        System.out.println("La figure a bien été ajouter");
    }
}
