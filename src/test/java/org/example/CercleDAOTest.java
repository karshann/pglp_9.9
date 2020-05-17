package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CercleDAOTest {

    @Test
    public void create() {
        Cercle c1=new Cercle("c",10.0,10.0,10.0);
        CercleDAO cd=new CercleDAO(1);
        assertEquals(cd.create(c1),c1);
    }

    @Test
    public void find() {
        Cercle c1=new Cercle("c",10.0,10.0,10.0);
        CercleDAO cd= new CercleDAO(1);
        Cercle c2 = cd.find("c");
        assertEquals(c1.nom , c2.nom);
        assertEquals(c1.rayon, c2.rayon,0.0);
        assertEquals(c1.centre.x, c2.centre.x,0.0);
        assertEquals(c1.centre.y, c2.centre.y,0.0);
    }

    @Test
    public void delete() {
        CercleDAO cd= new CercleDAO(1);
        cd.delete("c");
        assertEquals(cd.find("c") , null);
    }

    @Test
    public void update() {
    }
}