package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {

    Connection connect=null;

    public Statement stmt = null;

    public void connect() {

        try {
            Class.forName ("org.h2.Driver").getDeclaredConstructor().newInstance();
            connect = DriverManager.getConnection ("jdbc:h2:./BD/bd", "sa","sa");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void disconnect() {

        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
