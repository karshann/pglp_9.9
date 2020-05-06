package org.example;
import java.util.ArrayList;
import java.util.List;
public class Interpreteur {
    List<Composite> compositeListe;

    public Interpreteur()
    {
        this.compositeListe=new ArrayList<>();
    }

    public void ajoutListe(Composite composite) {
        this.compositeListe.add(composite);
    }

    public Composite getComposite(String name) {
        for (Composite composite:compositeListe) {
            if (composite.return_name().equals(name)) return composite;
        }
        return null;
    }
    public void affiche_Liste(){
        for (Composite composite:compositeListe) {
            composite.print();
        }
    }
    public void supressionListe(Composite composite){
        this.compositeListe.remove(composite);
    }

}
