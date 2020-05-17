package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleDAOTest {

    @Test
    public void create() {
        Rectangle R= new Rectangle("r",10,10,12,13);
        RectangleDAO RD=new RectangleDAO(1);
        assertEquals(RD.create(R),R);
    }

    @Test
    public void find() {
        Rectangle R= new Rectangle("r",10,10,12,13);
        RectangleDAO RD= new RectangleDAO(1);
        Rectangle R2 = RD.find("r");
        assertEquals(R.nom , R2.nom);
        assertEquals(R.p1.x, R2.p1.x,0.0);
        assertEquals(R.p1.y, R2.p1.y,0.0);
        assertEquals(R.p2.x, R2.p2.x,0.0);
        assertEquals(R.p2.y, R2.p2.y,0.0);
    }

    @Test
    public void delete() {
        RectangleDAO cd= new RectangleDAO(1);
        cd.delete("r");
        assertEquals(cd.find("r") , null);
    }

    @Test
    public void update() {
        Rectangle R= new Rectangle("r",10.0,10.0,5, 7);
        RectangleDAO RD=new RectangleDAO(1);
        assertEquals(RD.update(R),R);
    }
}