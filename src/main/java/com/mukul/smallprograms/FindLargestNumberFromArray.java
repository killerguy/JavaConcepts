package com.mukul.smallprograms;

public class FindLargestNumberFromArray {

    public static void main(String[] args) {
        System.out.println(findLargestNumber(new int[]{9, 8, 6, 5, 12}));
    }

    private static int findLargestNumber(int[] numbers) {

        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }
}
