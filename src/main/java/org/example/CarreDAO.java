package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CarreDAO extends DAO<Carre>{
    @Override
    public Carre create(Carre obj) {
        this.connect();
        try (PreparedStatement carreInsert = this.connect.prepareStatement("INSERT INTO Triangle(Nom, cote, x, y) values(?, ?, ?, ?)"); ) {
            carreInsert.setString(1, obj.Nom);
            carreInsert.setDouble(2, obj.cote);
            carreInsert.setDouble(3, obj.p1.x);
            carreInsert.setDouble(4, obj.p1.y);
            carreInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();
        return null;
    }

    @Override
    public Carre find(String id) {
        Carre c = null;
        this.connect();
        try (PreparedStatement select =
                     this.connect.prepareStatement("SELECT * FROM Carre C WHERE C.Nom = ?")) {
            select.setString(1, id);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    c =new Carre(res.getString("Nom"), Double.parseDouble(res.getString("cote")), Double.parseDouble(res.getString("x")),Double.parseDouble(res.getString("y")));
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
                     this.connect.prepareStatement("DELETE FROM Carre C WHERE C.Nom = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();

    }
}
