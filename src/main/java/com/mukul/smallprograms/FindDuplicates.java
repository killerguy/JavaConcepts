package com.mukul.smallprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList();

        list1.add("Hii");
        list1.add("Geeks");
        list1.add("for");
        list1.add("Geeks");

        list2.add("Hii");
        list2.add("Geeks");
        list2.add("Mukul");


        list1.stream()
                .filter(list2::contains)
                .collect(Collectors
                        .toList());

        System.out.println(list1);
    }
}
