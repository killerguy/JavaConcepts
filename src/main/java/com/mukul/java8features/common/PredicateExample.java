package com.mukul.java8features.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    private static final List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");

    public static void main(String[] args) {
        simplePredicate();
        combinedPredicatesUsingAnd();
        combinedPredicatesUsingOr();
        combinedPredicatesUsingOrAndNegate();
        collectionOfPredicatesUsingAnd();
        collectionOfPredicatesUsingOr();

    }

    public static void simplePredicate() {
        Predicate<String> predicate = name -> name.startsWith("A");

        List<String> result = names.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void combinedPredicatesUsingAnd() {
        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 5;

        List<String> result = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        System.out.println("-----------Combined Predicate Using AND---------------");
        System.out.println(result);
    }

    public static void combinedPredicatesUsingOr() {
        Predicate<String> predicate1 = str -> str.startsWith("J");
        Predicate<String> predicate2 = str -> str.length() < 4;

        List<String> result = names.stream()
                .filter(predicate1.or(predicate2))
                .collect(Collectors.toList());

        System.out.println("-----------Combined Predicate Using OR---------------");
        System.out.println(result);
    }

    public static void combinedPredicatesUsingOrAndNegate() {
        Predicate<String> predicate1 = str -> str.startsWith("J");
        Predicate<String> predicate2 = str -> str.length() < 4;

        List<String> result = names.stream()
                .filter(predicate1.or(predicate2.negate()))
                .collect(Collectors.toList());

        System.out.println("-----------Combined Predicate Using AND/OR and NEGATE---------------");
        System.out.println(result);
    }

    public static void collectionOfPredicatesUsingAnd() {
        List<Predicate<String>> allPredicates = new ArrayList<>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);

        List<String> result = names.stream()
                .filter(allPredicates.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());

        System.out.println("-----------Collection of Predicate using AND---------------");
        System.out.println(result);
    }

    public static void collectionOfPredicatesUsingOr() {
        List<Predicate<String>> allPredicates = new ArrayList<>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);

        List<String> result = names.stream()
                .filter(allPredicates.stream().reduce(x->false, Predicate::or))
                .collect(Collectors.toList());

        System.out.println("-----------Collection of  Predicate Using OR---------------");
        System.out.println(result);
    }
}