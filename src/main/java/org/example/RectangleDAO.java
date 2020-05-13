package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDAO extends DAO<Rectangle>{
    @Override
    public Rectangle create(Rectangle obj) {
        this.cdb.connect();
        try (PreparedStatement rectangleInsert = this.cdb.connect.prepareStatement("INSERT INTO Rectangle(nom,x1,y1,x2,y2) values(?, ?, ?, ?, ?)");) {
            rectangleInsert.setString(1, obj.nom);
            rectangleInsert.setDouble(2, obj.p1.x);
            rectangleInsert.setDouble(3, obj.p1.y);
            rectangleInsert.setDouble(4, obj.p2.x);
            rectangleInsert.setDouble(5, obj.p2.y);

            rectangleInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
        return null;
    }

    @Override
    public Rectangle find(String id) {
        Rectangle R = null;
        this.cdb.connect();
        try (PreparedStatement select = this.cdb.connect.prepareStatement("SELECT * FROM Rectangle R WHERE R.Nom = ?")) {
            select.setString(1, id);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    R =new Rectangle(res.getString("nom"), Double.parseDouble(res.getString("x1")), Double.parseDouble(res.getString("y1")),Double.parseDouble(res.getString("x2")), Double.parseDouble(res.getString("y2")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cdb.disconnect();

        return R;
    }

    @Override
    public void delete(String id) {

    }
}