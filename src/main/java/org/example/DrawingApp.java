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
        Scanner sc= new Scanner(System.in);
        while (true){
            D.Entree(sc.nextLine());

        }

    }
    public static void main( String[] args )
    {
        DrawingApp d=new DrawingApp();
        d.run();
    }
}
