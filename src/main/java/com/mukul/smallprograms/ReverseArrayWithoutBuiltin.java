package com.mukul.smallprograms;

import java.util.Arrays;

public class ReverseArrayWithoutBuiltin {

    public static void main(String[] args) {
        int str[] = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(str));
        reverseArrayUsingLoop(str);
        System.out.println(Arrays.toString(str));
    }

    public static void reverseArrayUsingLoop(int elements[]) {

        for (int start = 0, end = elements.length - 1; start < end; end--, start++) {
            int tempElement = elements[start];
            elements[start] = elements[end];
            elements[end] = tempElement;
        }
    }


}
