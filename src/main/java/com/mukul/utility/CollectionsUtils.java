package com.mukul.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsUtils {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList();
        List<String> vegetables = new ArrayList();
        List<String> sprouts = new ArrayList();

        fruits.add("Apple");
        fruits.add("Grapes");

        vegetables.add("Potato");
        vegetables.add("Cabbage");

        sprouts.add("Soybean");
        sprouts.add("Lentils");

        System.out.println(joinLists(fruits,vegetables,sprouts));
    }


    public static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
