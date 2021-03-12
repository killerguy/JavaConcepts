package com.mukul.smallprograms;

import java.util.*;
import java.util.stream.Collectors;

public class FindLargestNumberFromArray {

    public static void main(String[] args) {
        System.out.println(findLargestNumber(new int[]{9, 8, 6, 5, 12}));
        System.out.println(findMaxUsingStreams(new int[]{9, 8, 6, 5, 12}));
    }

    private static int findLargestNumber(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    private static int findMaxUsingStreams(int[] numbers) {
        List<Integer> stringList = Arrays.asList(9, 8, 6, 5, 12);

        List<Integer> numList = Arrays.stream(numbers).boxed().collect(Collectors.toList());


        Optional<Integer> min = stringList.stream().max(Comparator.naturalOrder());
        System.out.println(min.get());

        Optional<Integer> min1 = numList.stream().max(Comparator.naturalOrder());
        return min1.get();
    }
}
