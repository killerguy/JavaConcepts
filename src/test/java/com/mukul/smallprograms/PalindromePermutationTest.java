package com.mukul.smallprograms;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromePermutationTest {

    private final PalindromePermutation palindromePermutation = new PalindromePermutation();

    @Test
    public void withEmpty() {
        assertTrue(palindromePermutation.check(""));
    }

    @Test
    public void withOneChar() {
        assertTrue(palindromePermutation.check("a"));
    }

    @Test
    public void withTwoWords_OddLetters() {
        assertTrue(palindromePermutation.check("acto tac"));
    }

    @Test
    public void withTwoWords_OddLetters_ThreeOccurrences() {
        assertTrue(palindromePermutation.check("act atac"));
    }

    @Test
    public void withTwoWords_EvenLetters() {
        assertTrue(palindromePermutation.check("act cat"));
    }
}
