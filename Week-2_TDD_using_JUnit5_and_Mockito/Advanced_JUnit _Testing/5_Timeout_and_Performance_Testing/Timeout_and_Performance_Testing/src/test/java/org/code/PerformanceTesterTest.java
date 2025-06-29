package org.code;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {
    private final PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTask_CompletesWithinTime() {
        assertTimeout(Duration.ofMillis(500), () -> {
            tester.performTask();
        }, "Task should complete within 500 milliseconds");
    }
}
