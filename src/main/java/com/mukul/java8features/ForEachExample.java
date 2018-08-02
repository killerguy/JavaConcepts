package com.mukul.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForEachExample {
    public static void main(String[] args) {

        List<String> theListToIterate = Arrays.asList("We ", "will ", "iterate ", "a ", "List/Map ", "as ", "Example ");

        displayListIteration(theListToIterate);
        System.out.println();
        displayMapIteration(theListToIterate);
    }

    private static void displayListIteration(List<String> theListToIterate) {
        theListToIterate.forEach(System.out::print);
    }

    private static void displayMapIteration(List<String> theListToIterate) {
        Map<Integer, String> mapToIterate = theListToIterate.stream().collect(
                Collectors.toMap(theListToIterate::indexOf, s -> s)
        );
        mapToIterate.forEach((integer, s) -> System.out.print(integer + " - "+s));
    }

}
