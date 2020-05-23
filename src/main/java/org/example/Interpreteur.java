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
                    return cf.getComposite(name);
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
    public boolean verificationnom(String nom){
        CompositeForme cf;
        for (Composite composite:this.compositeListe) {
            if(composite.return_name().equals(nom)){
                System.err.println("Le nom existe déjà");
                return false;
            }
            else{
                if (composite instanceof CompositeForme){
                    cf=(CompositeForme)composite;
                    return cf.verif_nom(nom);
                }
            }
        }
        return true;
    }

    public void supressionComposite(Composite composite){
        this.compositeListe.remove(composite);
    }


    public void ajoutListe(Composite composite) {
        this.compositeListe.add(composite);
    }

    public void affiche_Liste(){
        for (Composite composite:this.compositeListe) {
            composite.print();
        }
    }

    public void supressionNom(Composite composite){
        CompositeForme cf;
        for (Composite comp:this.compositeListe) {
            if(comp.return_name().equals(composite.return_name())) {
                this.compositeListe.remove(composite);
                break;
            }
            if (comp instanceof CompositeForme){
                cf= ((CompositeForme) comp);
                cf.cremove(composite);
            }
        }
    }




}
