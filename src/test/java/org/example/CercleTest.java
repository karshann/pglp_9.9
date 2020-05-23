package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CercleTest {

    @Test
    public void move() {
        Cercle c= new Cercle("cercle",5.0,5.0,6.0);
        c.move(5,5);
        assertEquals(c.centre.x,10,0.0);
        assertEquals(c.centre.y,10.0,0);
    }


}