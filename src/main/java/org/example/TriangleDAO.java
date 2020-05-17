package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleDAO extends DAO<Triangle> {
    TriangleDAO(int dessin){
        this.dessin=dessin;
    }
    @Override
    public Triangle create(Triangle obj) {
        this.cdb.connect();
        try (PreparedStatement TriangleInsert = this.cdb.connect.prepareStatement("INSERT INTO Triangle(Nom,x1,y1,x2,y2,x3,y3,dessin) values(?, ?, ?, ?, ?, ?, ?, ?)");) {
            TriangleInsert.setString(1, obj.Nom);
            TriangleInsert.setDouble(2, obj.p1.x);
            TriangleInsert.setDouble(3, obj.p1.y);
            TriangleInsert.setDouble(4, obj.p2.x);
            TriangleInsert.setDouble(5, obj.p2.y);
            TriangleInsert.setDouble(6, obj.p3.x);
            TriangleInsert.setDouble(7, obj.p3.y);
            TriangleInsert.setInt(8, this.dessin);

            TriangleInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();
        return obj;
    }

    @Override
    public Triangle find(String id) {
            Triangle T = null;
            this.cdb.connect();
            try (PreparedStatement select = this.cdb.connect.prepareStatement("SELECT * FROM Triangle T WHERE T.Nom = ?")) {
                select.setString(1, id);
                try (ResultSet res = select.executeQuery()) {
                    if(res.next()) {
                        T =new Triangle(res.getString("Nom"), Double.parseDouble(res.getString("x1")), Double.parseDouble(res.getString("y1")),Double.parseDouble(res.getString("x2")), Double.parseDouble(res.getString("y2")),Double.parseDouble(res.getString("x3")), Double.parseDouble(res.getString("y3")));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            this.cdb.disconnect();

            return T;
    }

    @Override
    public Triangle update(Triangle obj) {
        this.cdb.connect();
        try (PreparedStatement update =
                     this.cdb.connect.prepareStatement("UPDATE Triangle SET x1= ? , y1= ? , x2= ? , y2= ?, x3= ? , y3= ?  WHERE Nom= ?")) {
            update.setDouble(1, obj.p1.x);
            update.setDouble(2, obj.p1.y);
            update.setDouble(3, obj.p2.x);
            update.setDouble(4, obj.p2.y);
            update.setDouble(5, obj.p3.x);
            update.setDouble(6, obj.p3.y);
            update.setString(7,obj.Nom);
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
                     this.cdb.connect.prepareStatement("DELETE FROM Triangle T WHERE T.Nom = ?"); ) {
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
                     this.cdb.connect.prepareStatement("DELETE FROM Triangle T WHERE T.dessin = ?"); ) {
            delete.setInt(1, dessin);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cdb.disconnect();

    }
}
