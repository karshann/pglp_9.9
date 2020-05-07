package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompositeFormeDAO extends DAO<CompositeForme> {
    @Override
    public CompositeForme create(CompositeForme obj) {
        this.connect();
        try (PreparedStatement CompositeFormeInsert = this.connect.prepareStatement("INSERT INTO CompositeForme(Nom,objNom,type) values(?, ?, ?)"); ) {
            List<Composite> enfantForme=obj.getEnfantForme();
            DAO D;
            for (Composite composite:enfantForme) {
                if(composite instanceof CompositeForme){
                    D=new CompositeFormeDAO();
                    D.create((CompositeForme)composite);
                    CompositeForme c=(CompositeForme)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.Nom);
                    CompositeFormeInsert.setInt(3,0);

                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Carre){
                    D=new CarreDAO();
                    D.create((Carre)composite);
                    Carre c=(Carre)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.Nom);
                    CompositeFormeInsert.setInt(3,1);
                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Rectangle){
                    D=new RectangleDAO();
                    D.create((Rectangle)composite);
                    Rectangle c=(Rectangle)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.nom);
                    CompositeFormeInsert.setInt(3,2);
                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Triangle){
                    D=new TriangleDAO();
                    D.create((Triangle)composite);
                    Triangle c=(Triangle)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.Nom);
                    CompositeFormeInsert.setInt(3,3);
                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Cercle){
                    D=new CercleDAO();
                    D.create((Cercle)composite);
                    Cercle c=(Cercle)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.nom);
                    CompositeFormeInsert.setInt(3,4);
                    CompositeFormeInsert.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();
        return null;
    }

    @Override
    public CompositeForme find(String id) {
        CompositeForme C=new CompositeForme(id);
        this.connect();
        int type;
        DAO D;
        try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM CompositeForme C WHERE C.Nom = ?");){
            select.setString(1, id);
            try(ResultSet res = select.executeQuery()){
                while(res.next()){
                    type=Integer.parseInt(res.getString("type"));
                    if (type == 0){
                        D=new CompositeFormeDAO();
                        C.addComposite((CompositeForme)D.find("objNom"));
                    }
                    else if (type == 1){
                        D=new CarreDAO();
                        C.addComposite((Carre)D.find(res.getString("objNom")));

                    }
                    else if (type == 2){
                        D=new RectangleDAO();
                        C.addComposite((Rectangle)D.find(res.getString("objNom")));

                    }
                    else if (type == 3){
                        D=new TriangleDAO();
                        C.addComposite((Triangle)D.find(res.getString("objNom")));
                    }
                    else if (type == 4){
                        D=new CercleDAO();
                        C.addComposite((Cercle)D.find(res.getString("objNom")));
                    }
                }
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        return C;
    }

    @Override
    public void delete(String id) {
        this.connect();
        try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM CompositeForm C WHERE C.Nom = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();
    }
}
