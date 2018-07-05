package com.mukul.smallprograms;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberSwapperTest {
    private NumberSwapper s = new NumberSwapper();

    @Test
    public void test() {
        int[] ab = {1, 2};
        s.swap(ab);
        assertEquals(ab[0], 2);
        assertEquals(ab[1], 1);
    }

}