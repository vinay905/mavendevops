package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testAdd() {
        assertEquals(5, app.add(2, 3));
        assertEquals(0, app.add(-1, 1));
        assertEquals(-5, app.add(-2, -3));
    }

    @Test
    public void testIsEven() {
        assertTrue(app.isEven(2));
        assertTrue(app.isEven(0));
        assertFalse(app.isEven(1));
        assertFalse(app.isEven(-1));
        assertTrue(app.isEven(-2));
    }
}
