package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.h2.jdbcx.JdbcDataSource;

/**
 * Hello world!
 *
 */
public class DrawingApp
{
    Connection connection;
    DrawingApp()  {
        Statement stmt = null;
        try{
            Class.forName ("org.h2.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection ("jdbc:h2:./BD/bd","sa","sa");
            stmt=connection.createStatement();
            stmt.execute("DROP TABLE Carre");
            stmt.execute("DROP TABLE Cercle");
            stmt.execute("DROP TABLE Rectangle");
            stmt.execute("DROP TABLE Triangle");
            stmt.execute("CREATE TABLE Carre( nom varchar(50) PRIMARY KEY NOT NULL, x double, y double, cote double)");
            stmt.execute("CREATE TABLE Cercle( nom varchar(50) PRIMARY KEY NOT NULL, x double, y double, rayon double)");
            stmt.execute("CREATE TABLE Rectangle( nom varchar(50) PRIMARY KEY NOT NULL, x1 double, y1 double, x2 double, y2 double)");
            stmt.execute("CREATE TABLE Triangle( nom varchar(50) PRIMARY KEY NOT NULL, x1 double, y1 double, x2 double, y2 double, x3 double, y3 double)");
            connection.close();
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("Chargement de la base de données");
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        DrawingTUI D = new DrawingTUI();
        D.init();
        Scanner sc= new Scanner(System.in);
        Commande commande;
        while (true){
           commande= D.nextCommande(sc.nextLine());
           commande.execute();
           commande.print();
        }

    }
    public static void main( String[] args )throws  NullPointerException
    {
        DrawingApp d=new DrawingApp();
        d.run();
    }
}
