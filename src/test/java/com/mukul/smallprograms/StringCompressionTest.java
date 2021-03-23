package com.mukul.smallprograms;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    private final StringCompression stringCompression = new StringCompression();

    @Test
    public void withOneSingleChar() {
        assertEquals("a", stringCompression.compress("a"));
    }

    @Test
    public void withTwoChars() {
        assertEquals("aa", stringCompression.compress("aa"));
    }

    @Test
    public void withThreeChars() {
        assertEquals("3a", stringCompression.compress("aaa"));
    }

    @Test
    public void withDifferentChars() {
        assertEquals("aaab", stringCompression.compress("aaab"));
    }

    @Test
    public void withDifferentChars_RepeatingSeveralTimes() {
        assertEquals("3a2b", stringCompression.compress("aaabb"));
    }

    @Test
    public void withDifferentChars_RepeatingInMoreSeqs() {
        assertEquals("3a2b2a", stringCompression.compress("aaabbaa"));
    }

}
