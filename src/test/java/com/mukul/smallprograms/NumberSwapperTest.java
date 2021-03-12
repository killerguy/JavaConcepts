package com.mukul.smallprograms;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberSwapperTest {
    private final NumberSwapper swapper = new NumberSwapper();

    @Test
    public void test() {
        int[] ab = {1, 2};
        swapper.swap(ab);
        assertEquals(ab[0], 2);
        assertEquals(ab[1], 1);
    }

}
