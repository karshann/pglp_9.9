package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void move() {
        Triangle triangle=new Triangle("t",1,2,3,4,5,6);
        triangle.move(5,5);
        assertEquals(triangle.p1.x,6,0);
        assertEquals(triangle.p2.x,8,0);
        assertEquals(triangle.p3.x,10,0);
        assertEquals(triangle.p1.y,7,0);
        assertEquals(triangle.p2.y,9,0);
        assertEquals(triangle.p3.y,11,0);

    }
}