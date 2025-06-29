package org.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {
    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testThrowException_WhenShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        }, "Expected IllegalArgumentException when shouldThrow is true");
    }

    @Test
    void testThrowException_WhenShouldNotThrow() {
        assertDoesNotThrow(() -> {
            thrower.throwException(false);
        }, "Did not expect any exception when shouldThrow is false");
    }
}
