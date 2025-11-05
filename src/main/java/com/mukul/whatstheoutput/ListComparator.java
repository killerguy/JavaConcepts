package com.mukul.whatstheoutput;

import java.util.*;

public class ListComparator {

    public static <T> void compareLists(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);

        if (set1.equals(set2)) {
            System.out.println("Both lists have the same elements.");
        } else {
            Set<T> onlyInList1 = new HashSet<>(set1);
            onlyInList1.removeAll(set2);

            Set<T> onlyInList2 = new HashSet<>(set2);
            onlyInList2.removeAll(set1);

            System.out.println("Elements only in first list: " + onlyInList1);
            System.out.println("Elements only in second list: " + onlyInList2);
        }
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("A", "B", "C", "D");
        List<String> list2 = Arrays.asList("A", "B", "C", "D");
        System.out.println("Scenario 1: Both lists are the same");
        compareLists(list1, list2);

        List<String> list3 = Arrays.asList("A", "B", "C", "D");
        List<String> list4 = Arrays.asList("B", "C", "D", "E");
        System.out.println("\nScenario 2: Lists have different elements");
        compareLists(list3, list4);

        List<String> list5 = Arrays.asList("A", "B");
        List<String> list6 = Collections.emptyList();
        System.out.println("\nScenario 3: One list is empty");
        compareLists(list5, list6);

        List<String> list7 = Collections.emptyList();
        List<String> list8 = Collections.emptyList();
        System.out.println("\nScenario 4: Both lists are empty");
        compareLists(list7, list8);
    }

}

