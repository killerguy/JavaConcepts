package com.mukul.smallprograms;

public class NumberSwapper {
    public void swap(int[] ab) {
        ab[0] = ab[0] ^ ab[1];
        ab[1] = ab[0] ^ ab[1];
        ab[0] = ab[0] ^ ab[1];
    }
}
