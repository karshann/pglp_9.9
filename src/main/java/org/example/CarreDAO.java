package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CarreDAO extends DAO<Carre>{
    @Override
    public Carre create(Carre obj) {
        this.cdb.connect();

        try {
            PreparedStatement carreInsert = this.cdb.connect.prepareStatement("INSERT INTO Carre(Nom, x, y, cote) values(?, ?, ?, ?)");
            carreInsert.setString(1, obj.Nom);
            carreInsert.setDouble(3, obj.p1.x);
            carreInsert.setDouble(4, obj.p1.y);
            carreInsert.setDouble(2, obj.cote);
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
}
