package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RectangleDAO extends DAO<Rectangle>{
    RectangleDAO(int dessin){
        this.dessin=dessin;
    }
    @Override
    public Rectangle create(Rectangle obj) {
        this.cdb.connect();
        try (PreparedStatement rectangleInsert = this.cdb.connect.prepareStatement("INSERT INTO Rectangle(nom,x1,y1,x2,y2,dessin) values(?, ?, ?, ?, ?, ?)");) {
            rectangleInsert.setString(1, obj.nom);
            rectangleInsert.setDouble(2, obj.p1.x);
            rectangleInsert.setDouble(3, obj.p1.y);
            rectangleInsert.setDouble(4, obj.p2.x);
            rectangleInsert.setDouble(5, obj.p2.y);
            rectangleInsert.setInt(6, this.dessin);
            rectangleInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
        return obj;
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
    public Rectangle update(Rectangle obj) {
        this.cdb.connect();
        try (PreparedStatement update =
                     this.cdb.connect.prepareStatement("UPDATE Rectangle SET x1= ? , y1= ? , x2= ? , y2= ?  WHERE Nom= ?")) {
            update.setDouble(1, obj.p1.x);
            update.setDouble(2, obj.p1.y);
            update.setDouble(3, obj.p2.x);
            update.setDouble(4, obj.p2.y);
            update.setString(5,obj.nom);
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
                     this.cdb.connect.prepareStatement("DELETE FROM Rectangle R WHERE R.Nom = ?"); ) {
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
                     this.cdb.connect.prepareStatement("DELETE FROM Rectangle R WHERE R.dessin = ?"); ) {
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
        try (PreparedStatement select = this.cdb.connect.prepareStatement("SELECT * FROM Rectangle R WHERE R.dessin = ?")) {
            select.setInt(1, this.dessin);
            try (ResultSet res = select.executeQuery()) {
                if(res.next()) {
                    interpreteur.compositeListe.add(new Rectangle(res.getString("nom"), Double.parseDouble(res.getString("x1")), Double.parseDouble(res.getString("y1")),Double.parseDouble(res.getString("x2")), Double.parseDouble(res.getString("y2"))));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cdb.disconnect();
    }
}
