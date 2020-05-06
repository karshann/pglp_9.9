package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class DrawingApp
{
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
