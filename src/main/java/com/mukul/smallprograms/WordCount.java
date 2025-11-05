package com.mukul.smallprograms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        fruits.stream()
                .map(String::toLowerCase)
                .distinct()
                .forEach(fruit -> {
                    long count = fruits.stream()
                            .filter(f -> f.equalsIgnoreCase(fruit))
                            .count();
                    System.out.println(fruit + ": " + count);
                });

        Map<String, Long> collect = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Using groupingBy: " + collect);
    }
}
