package org.code;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    private Calculator calculator = new Calculator();

    @Test
    @Order(1)
    void testAddition(){
        System.out.println("Running first test for addition");
        int a = 5;
        int b = 9;
        int result = calculator.add(a,b);
        assertEquals(14, result, "Addition should return the sum of two numbers");
    }

    @Test
    @Order(3)
    void testSubtraction(){
        System.out.println("Running third test for subtraction");
        int a = 15;
        int b = 4;
        int result = calculator.subtract(a,b);
        assertEquals(11,result,"Subtraction should return the difference between two numbers");
    }

    @Test
    @Order(2)
    void testMultiplication(){
        System.out.println("Running second test for multiplication");
        int a = 25;
        int b = 4;
        int result = calculator.multiply(a,b);
        assertEquals(100,result,"Multiplication should return the product of two numbers");
    }

    @Test
    @Order(4)
    void testDivsion(){
        System.out.println("Running forth test for division");
        int a = 60;
        int b = 12;
        int result = calculator.divide(a,b);
        assertEquals(5,result,"Division should return the quotient of two numbers");
    }
}
