package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleDAO extends DAO<Cercle>{
    @Override
    public Cercle create(Cercle obj) {
        this.connect();
        try (PreparedStatement cercleInsert =
                     this.connect.prepareStatement("INSERT INTO Cercle(Nom, x, y, rayon) values(?, ?, ?, ?)"); ) {
            cercleInsert.setString(1, obj.nom);
            cercleInsert.setDouble(2, obj.centre.x);
            cercleInsert.setDouble(3, obj.centre.y);
            cercleInsert.setDouble(4, obj.rayon);
            cercleInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();
        return null;
    }

    @Override
    public Cercle find(String id) {
        Cercle c = null;
        this.connect();
        try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Cercle C WHERE C.Nom = ?")) {
            select.setString(1, id);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    c =new Cercle(res.getString("Nom"), Double.parseDouble(res.getString("x")), Double.parseDouble(res.getString("y")),Double.parseDouble(res.getString("cote")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();

        return c;
    }


    @Override
    public void delete(String id) {
        this.connect();
        try (PreparedStatement delete =
                     this.connect.prepareStatement("DELETE FROM Cercle C WHERE C.Nom = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();
    }
}
