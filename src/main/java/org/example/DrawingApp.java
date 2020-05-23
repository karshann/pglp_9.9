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
            stmt.execute("CREATE TABLE IF NOT EXISTS CompositeForme( Nom varchar(50) , objNom varchar(50), type varchar(50), dessin integer)");
            stmt.execute("CREATE TABLE IF NOT EXISTS Carre( nom varchar(50) , x double, y double, cote double, dessin integer, PRIMARY KEY(nom,dessin));");
            stmt.execute("CREATE TABLE IF NOT EXISTS Cercle( nom varchar(50) , x double, y double, rayon double,dessin integer,PRIMARY KEY(nom,dessin));");
            stmt.execute("CREATE TABLE IF NOT EXISTS Rectangle( nom varchar(50) , x1 double, y1 double, x2 double, y2 double,dessin integer,PRIMARY KEY(nom,dessin));");
            stmt.execute("CREATE TABLE IF NOT EXISTS Triangle( nom varchar(50) , x1 double, y1 double, x2 double, y2 double, x3 double, y3 double,dessin integer,PRIMARY KEY(nom,dessin));");
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
