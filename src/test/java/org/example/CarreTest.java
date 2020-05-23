package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarreTest {

    @Test
    public void move() {
        Carre c= new Carre("carre",5.0,5.0,6.0);
        c.move(5,5);
        assertEquals(c.p1.x,10,0.0);
        assertEquals(c.p1.y,11.0,0);
    }

}