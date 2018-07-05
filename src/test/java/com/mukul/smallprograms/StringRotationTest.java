package com.mukul.smallprograms;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringRotationTest {
    private StringRotation rotation = new StringRotation();

    @Test
    public void withEmpty() {
        assertTrue(rotation.rotated("", ""));
    }

    @Test
    public void withSameWord() {
        assertTrue(rotation.rotated("hello", "hello"));
    }

    @Test
    public void withRotated() {
        assertTrue(rotation.rotated("hello", "llohe"));
    }

    @Test
    public void withSubstring_ButDifferentSize() {
        assertFalse(rotation.rotated("hello", "llo"));
    }

    @Test
    public void withDifferentWords() {
        assertFalse(rotation.rotated("hello", "world"));
    }

    @Test
    public void withNotRotated() {
        assertFalse(rotation.rotated("hello", "oehll"));
    }

}