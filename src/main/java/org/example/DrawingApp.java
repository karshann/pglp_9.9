package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Chargement driver fini");
            connection = DriverManager.getConnection("jdbc:derby:test;create=true");
            stmt=connection.createStatement();
            stmt.execute("CREATE TABLE Carre( nom varchar(50) PRIMARY KEY NOT NULL, x double, y double, cote double)");
            stmt.execute("CREATE TABLE Cercle( nom varchar(50) PRIMARY KEY NOT NULL, x double, y double, rayon double)");
            stmt.execute("CREATE TABLE Rectangle( nom varchar(50) PRIMARY KEY NOT NULL, x1 double, y1 double, x2 double, y2 double)");
            stmt.execute("CREATE TABLE Triangle( nom varchar(50) PRIMARY KEY NOT NULL, x1 double, y1 double, x2 double, y2 double, x3 double, y3 double)");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Chargement de la base de données");
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
    public static void main( String[] args )
    {
        DrawingApp d=new DrawingApp();
        d.run();
    }
}
