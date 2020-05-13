package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarreDAOTest {

    @Test
    public void create() {
        Carre c1= new Carre("c1",10.0,10.0,10.0);
        CarreDAO cd= new CarreDAO();
        assertEquals(cd.create(c1),c1);
    }

    @Test
    public void find() {
        Carre c1= new Carre("c1",10.0,10.0,10.0);
        CarreDAO cd= new CarreDAO();
        Carre c2 = cd.find("c1");
        assertEquals(c1.Nom , c2.Nom);
        assertEquals(c1.cote, c2.cote,0.0);
        assertEquals(c1.p1.x, c2.p1.x,0.0);
        assertEquals(c1.p1.y, c2.p1.y,0.0);

    }

    @Test
    public void delete() {
        CarreDAO cd= new CarreDAO();
        cd.delete("c1");
        assertEquals(cd.find("c1") , null);
    }

    @Test
    public void update() {
        Carre c1= new Carre("c1",10.0,10.0,5);
        CarreDAO cd=new CarreDAO();
        assertEquals(cd.update(c1),c1);
    }
}