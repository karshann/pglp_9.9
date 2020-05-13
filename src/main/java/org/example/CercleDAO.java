package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleDAO extends DAO<Cercle>{
    @Override
    public Cercle create(Cercle obj) {
        this.cdb.connect();
        try {
            PreparedStatement cercleInsert = this.cdb.connect.prepareStatement("INSERT INTO Cercle(Nom, x, y, rayon) values(?, ?, ?, ?)");
            cercleInsert.setString(1, obj.nom);
            cercleInsert.setDouble(2, obj.centre.x);
            cercleInsert.setDouble(3, obj.centre.y);
            cercleInsert.setDouble(4, obj.rayon);
            cercleInsert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
        return obj;
    }

    @Override
    public Cercle find(String id) {
        Cercle c = null;
        this.cdb.connect();
        try (PreparedStatement select = this.cdb.connect.prepareStatement("SELECT * FROM Cercle C WHERE C.Nom = ?")) {
            select.setString(1, id);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    c =new Cercle(res.getString("Nom"), Double.parseDouble(res.getString("x")), Double.parseDouble(res.getString("y")),Double.parseDouble(res.getString("rayon")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cdb.disconnect();

        return c;
    }


    @Override
    public void delete(String id) {
        this.cdb.connect();
        try (PreparedStatement delete =
                     this.cdb.connect.prepareStatement("DELETE FROM Cercle C WHERE C.Nom = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
    }
}