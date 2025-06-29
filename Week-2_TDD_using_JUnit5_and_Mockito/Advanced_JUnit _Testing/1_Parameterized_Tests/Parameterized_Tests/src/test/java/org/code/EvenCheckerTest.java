package org.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {
    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2})
    void testIsEven_WithEvenNumbers(int input) {
        assertTrue(checker.isEven(input), input + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
    void testIsEven_WithOddNumbers(int input) {
        assertFalse(checker.isEven(input), input + " should be odd");
    }
}
