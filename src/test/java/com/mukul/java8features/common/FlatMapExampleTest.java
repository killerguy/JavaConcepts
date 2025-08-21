
package com.mukul.java8features.common;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FlatMapExampleTest {

    @Test
    void testSimpleFlatMapExampleAndSinglePipelineFlatMapExample() {
        FlatMapExample example = new FlatMapExample();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            example.simpleFlatMapExample();
            example.singlePipelineFlatMapExample();
        } finally {
            System.setOut(originalOut);
        }

        String output = outContent.toString();

        // Check for expected output
        assertTrue(output.contains("Bar1 <- Foo1"));
        assertTrue(output.contains("Bar2 <- Foo2"));
        assertTrue(output.contains("Bar3 <- Foo3"));
    }
}