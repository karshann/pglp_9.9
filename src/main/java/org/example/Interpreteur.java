package org.example;
import java.util.ArrayList;
import java.util.List;
public class Interpreteur {
    int dessin=0;
    List<List<Composite>> desssins;
    List<String>nomdessin;
    List<Composite> compositeListe;

    public Interpreteur()
    {
        this.compositeListe=new ArrayList<>();
        this.desssins=new ArrayList<>();
        this.nomdessin=new ArrayList<>();
    }
    public void set_dessin(){
        if (dessin!=0){
            List<Composite>copy=new ArrayList<>(compositeListe);
            this.desssins.add(this.dessin-1,copy);

        }
        this.compositeListe.clear();
    }
    public Composite getComposite_(String name){
        CompositeForme cf;
        for (Composite composite : this.compositeListe){
            if(composite.return_name().equals(name)) return composite;
            else{
                if (composite instanceof CompositeForme){
                    cf=(CompositeForme)composite;
                    for (Composite composite1 : cf.getEnfantForme()){
                        if(composite1.return_name().equals(name)) return composite1;
                    }
                }
            }
        }
        return null;
    }

    public Composite getComposite(String name){
        for (Composite composite : this.compositeListe){
            if(composite.return_name().equals(name)) return composite;
        }
        return null;
    }

    public List<Composite> getdessin(int dessin){
        return this.desssins.get(dessin);
    }

    public void supressionComposite(Composite composite){
        this.compositeListe.remove(composite);
    }

    public void ajout_nom(String S){
        this.nomdessin.add(S);
    }
    public void new_dessin(){
        this.dessin++;
    }


    public void ajoutListe(Composite composite) {
        this.compositeListe.add(composite);
    }

    public void affiche_Liste(){
        for (Composite composite:this.compositeListe) {
            composite.print();
        }
    }
    public void supressionListe(Composite composite){
        this.compositeListe.remove(composite);
    }
    public Interpreteur gotodessin(int dessin){
        List<Composite> copy = new ArrayList<>(this.compositeListe);
        this.desssins.add(this.dessin,copy);
        this.dessin=dessin;
        this.compositeListe.clear();
        this.compositeListe=new ArrayList<>(this.desssins.get(this.dessin));
        return this;
    }
    public void afficher(List<Composite> list){
        for (Composite composite:list) {
            composite.print();
        }
    }


}
