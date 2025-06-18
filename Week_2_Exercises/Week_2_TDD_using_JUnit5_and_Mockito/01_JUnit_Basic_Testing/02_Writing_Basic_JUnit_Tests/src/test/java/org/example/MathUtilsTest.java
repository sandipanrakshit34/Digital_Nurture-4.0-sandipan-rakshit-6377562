package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MathUtilsTest {

    @Test
    public void testMultiply() {
        MathUtils math = new MathUtils();
        int result = math.multiply(4, 5);
        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        MathUtils math = new MathUtils();
        int result = math.divide(10, 2);
        assertEquals(5, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        MathUtils math = new MathUtils();
        math.divide(10, 0);
    }
}
