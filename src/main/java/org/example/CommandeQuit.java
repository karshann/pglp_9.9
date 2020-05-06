package org.example;

public class CommandeQuit implements Commande{


    CommandeQuit(){
    }
    @Override
    public void init(String S) {
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void print() {
    }
}
