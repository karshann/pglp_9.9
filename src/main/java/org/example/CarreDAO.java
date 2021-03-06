package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class CarreDAO extends DAO<Carre>{
    CarreDAO(int dessin){
        this.dessin=dessin;
    }
    @Override
    public Carre create(Carre obj) {
        this.cdb.connect();

        try {
            PreparedStatement carreInsert = this.cdb.connect.prepareStatement("INSERT INTO Carre(Nom, x, y, cote, dessin) values(?, ?, ?, ?, ?)");
            carreInsert.setString(1, obj.Nom);
            carreInsert.setDouble(2, obj.p1.x);
            carreInsert.setDouble(3, obj.p1.y);
            carreInsert.setDouble(4, obj.cote);
            carreInsert.setInt(5, this.dessin);
            carreInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
        return obj;
    }

    @Override
    public Carre find(String id) {
        Carre c = null;
        this.cdb.connect();
        try (PreparedStatement select =
                     this.cdb.connect.prepareStatement("SELECT * FROM Carre C WHERE C.Nom = ?")) {
            select.setString(1, id);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    c =new Carre(res.getString("Nom"), Double.parseDouble(res.getString("cote")), Double.parseDouble(res.getString("x")),Double.parseDouble(res.getString("y")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cdb.disconnect();

        return c;
    }

    @Override
    public Carre update(Carre obj) {
        this.cdb.connect();
        try (PreparedStatement update =
                     this.cdb.connect.prepareStatement("UPDATE Carre SET x= ? , y= ? , cote =? WHERE Nom= ?")) {
            update.setDouble(1, obj.p1.x);
            update.setDouble(2, obj.p1.y);
            update.setDouble(3, obj.cote);
            update.setString(4,obj.Nom);
            update.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        this.cdb.disconnect();

        return obj;
    }

    @Override
    public void delete(String id) {
        this.cdb.connect();
        try (PreparedStatement delete =
                     this.cdb.connect.prepareStatement("DELETE FROM Carre C WHERE C.Nom = ?"); ) {
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
        try (PreparedStatement delete =
                     this.cdb.connect.prepareStatement("DELETE FROM Carre C WHERE C.dessin = ?"); ) {
            delete.setInt(1, dessin);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
    }

    @Override
    public void load(Interpreteur interpreteur) {
        this.cdb.connect();
        try (PreparedStatement select =
                     this.cdb.connect.prepareStatement("SELECT * FROM Carre C WHERE C.dessin = ?")) {
            select.setInt(1, this.dessin);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    interpreteur.compositeListe.add(new Carre(res.getString("Nom"), Double.parseDouble(res.getString("cote")), Double.parseDouble(res.getString("x")),Double.parseDouble(res.getString("y"))));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cdb.disconnect();
    }
}
