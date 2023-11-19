package com.example.myapplication;


import static junit.framework.TestCase.assertEquals;

import org.testng.annotations.Test;

public class TestMack {

    @Test
    public void testCgetX() {
        C1floor c = new C1floor(2.75F, 144, 110);
        float expected = 100;
        assertEquals(expected,c.getX(110));
    }
    @Test
    public void testCgetY() {
        C1floor c = new C1floor(2.75F, 144, 110);
        float expected = 640;
        assertEquals(expected,c.getY(110));
    }

    @Test
    public void testPathmakergetX() {
        int[] Array = {10, 60, 61, 20};
        PathMaker c = new PathMaker(2.75F, Array);
        float expected = 640;
        assertEquals(expected,c.getY(110));
    }


}
