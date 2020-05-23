package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void move() {
        Rectangle rectangle=new Rectangle("t",1,2,3,4);
        rectangle.move(5,5);
        assertEquals(rectangle.p1.x,6,0);
        assertEquals(rectangle.p1.y,7,0);
        assertEquals(rectangle.p2.x,8,0);
        assertEquals(rectangle.p2.y,9,0);

    }
}