package org.example;

public class CommandeLoad implements Commande{
    Interpreteur i;
    int dessin;

    /**
     *
     * @param I
     */
    public CommandeLoad(Interpreteur I) {
       this.i=I;
    }

    /**
     *
     * @param S
     */
    @Override
    public void init(String S) {
        this.dessin=Integer.parseInt(S.replace("load","").replace("(","").replace(")",""));
    }

    /**
     *
     */
    @Override
    public void execute() {
        DAO D;
        D=new CarreDAO(this.dessin);
        D.load(this.i);
        D=new CercleDAO(this.dessin);
        D.load(this.i);
        D=new RectangleDAO(this.dessin);
        D.load(this.i);
        D=new TriangleDAO(this.dessin);
        D.load(this.i);
        D=new CompositeFormeDAO(this.dessin);
        D.load(this.i);

    }

    /**
     *
     */
    @Override
    public void print() {
        this.i.affiche_Liste();
    }
}
