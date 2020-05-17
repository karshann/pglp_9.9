package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompositeFormeDAO extends DAO<CompositeForme> {
    public CompositeFormeDAO(int dessin){
        this.dessin=dessin;
    }
    @Override
    public CompositeForme create(CompositeForme obj) {
        this.cdb.connect();
        try (PreparedStatement CompositeFormeInsert = this.cdb.connect.prepareStatement("INSERT INTO CompositeForme(Nom,objNom,type,dessin) values(?, ?, ?, ?)")) {
            List<Composite> enfantForme=obj.getEnfantForme();
            DAO D;
            for (Composite composite:enfantForme) {
                if(composite instanceof CompositeForme){
                    D=new CompositeFormeDAO(this.dessin);
                    D.create((CompositeForme)composite);
                    CompositeForme c=(CompositeForme)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.Nom);
                    CompositeFormeInsert.setInt(3,0);
                    CompositeFormeInsert.setInt(4,this.dessin);

                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Carre){
                    D=new CarreDAO(this.dessin);
                    D.create((Carre)composite);
                    Carre c=(Carre)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.Nom);
                    CompositeFormeInsert.setInt(3,1);
                    CompositeFormeInsert.setInt(4,this.dessin);
                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Rectangle){
                    D=new RectangleDAO(this.dessin);
                    D.create((Rectangle)composite);
                    Rectangle c=(Rectangle)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.nom);
                    CompositeFormeInsert.setInt(3,2);
                    CompositeFormeInsert.setInt(4,this.dessin);
                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Triangle){
                    D=new TriangleDAO(this.dessin);
                    D.create((Triangle)composite);
                    Triangle c=(Triangle)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.Nom);
                    CompositeFormeInsert.setInt(3,3);
                    CompositeFormeInsert.setInt(4,this.dessin);
                    CompositeFormeInsert.executeUpdate();
                }
                if(composite instanceof Cercle){
                    D=new CercleDAO(this.dessin);
                    D.create((Cercle)composite);
                    Cercle c=(Cercle)composite;
                    CompositeFormeInsert.setString(1, obj.Nom);
                    CompositeFormeInsert.setString(2,c.nom);
                    CompositeFormeInsert.setInt(3,4);
                    CompositeFormeInsert.setInt(4,this.dessin);
                    CompositeFormeInsert.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
        return null;
    }

    @Override
    public CompositeForme find(String id) {
        CompositeForme C=new CompositeForme(id);
        this.cdb.connect();
        int type;
        DAO D;
        try (PreparedStatement select = this.cdb.connect.prepareStatement("SELECT * FROM CompositeForme C WHERE C.Nom = ?");){
            select.setString(1, id);
            try(ResultSet res = select.executeQuery()){
                while(res.next()){
                    type=Integer.parseInt(res.getString("type"));
                    if (type == 0){
                        D=new CompositeFormeDAO(this.dessin);
                        C.addComposite((CompositeForme)D.find("objNom"));
                    }
                    else if (type == 1){
                        D=new CarreDAO(this.dessin);
                        C.addComposite((Carre)D.find(res.getString("objNom")));

                    }
                    else if (type == 2){
                        D=new RectangleDAO(this.dessin);
                        C.addComposite((Rectangle)D.find(res.getString("objNom")));

                    }
                    else if (type == 3){
                        D=new TriangleDAO(this.dessin);
                        C.addComposite((Triangle)D.find(res.getString("objNom")));
                    }
                    else if (type == 4){
                        D=new CercleDAO(this.dessin);
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
    public CompositeForme update(CompositeForme obj) {
        return null;
    }



    @Override
    public void delete(String id) {
        this.cdb.connect();
        try (PreparedStatement delete = this.cdb.connect.prepareStatement("DELETE FROM CompositeForme C WHERE C.Nom = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
    }

    @Override
    public void deletedessin(int dessin) {
        this.cdb.connect();
        try (PreparedStatement delete = this.cdb.connect.prepareStatement("DELETE FROM CompositeForme C WHERE C.dessin = ?"); ) {
            delete.setInt(1, dessin);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
    }
}
