package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleDAOTest {

    @Test
    public void create() {
        Triangle T =new Triangle("t",5,2,6,4,7,8);
        TriangleDAO TD =new TriangleDAO();
        assertEquals(TD.create(T),T);
    }

    @Test
    public void find() {
        Triangle T1=new Triangle("t",5,2,6,4,7,8);
        TriangleDAO TD=new TriangleDAO();
        Triangle T2=TD.find("t");
        assertEquals(T1.Nom , T2.Nom);
        assertEquals(T1.p1.x, T2.p1.x,0.0);
        assertEquals(T1.p1.y, T2.p1.y,0.0);
        assertEquals(T1.p2.x, T2.p2.x,0.0);
        assertEquals(T1.p2.y, T2.p2.y,0.0);
        assertEquals(T1.p3.x, T2.p3.x,0.0);
        assertEquals(T1.p3.y, T2.p3.y,0.0);
    }

    @Test
    public void delete() {
        TriangleDAO TD= new TriangleDAO();
        TD.delete("t");
        assertEquals(TD.find("t") , null);
    }

    @Test
    public void update() {
        Triangle T1=new Triangle("t",5,2,6,4,7,8);
        TriangleDAO RD=new TriangleDAO();
        assertEquals(RD.update(T1),T1);
    }
}