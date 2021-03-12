package com.mukul.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleArrayListSorting {

    public static void main(String[] args) {
        simpleObjectCustomSorting();
        System.out.println("----------------");
        simpleObjectSorting();
        simpleSorting();
    }

    public static void simpleObjectSorting() {
        ArrayList<Student> arraylist = getStudentDetails();

        Collections.sort(arraylist);

        for (Student str : arraylist) {
            System.out.println(str.toString());
        }
    }

    public static void simpleObjectCustomSorting() {
        ArrayList<Student> arraylist = getStudentDetails();

        arraylist.sort((o1, o2) -> (o1.getStudentName()).compareTo(o2.getStudentName()) > 0 ? -1 : 1);

        for (Student str : arraylist) {
            System.out.println("Runtime Sorting: " + str.toString());
        }

        Collections.sort(arraylist, new SortByRollNumber());

        for (Student str : arraylist) {
            System.out.println("Collections custom Sorting based on rollNo.: " + str.toString());
        }

        Collections.sort(arraylist, Collections.reverseOrder(new SortByRollNumber()));

        for (Student str : arraylist) {
            System.out.println("Collections reverse custom Sorting based on rollNo.: " + str.toString());
        }

    }

    private static ArrayList<Student> getStudentDetails() {
        ArrayList<Student> arraylist = new ArrayList<>();
        arraylist.add(new Student(223, "Virat Kohli", 26));
        arraylist.add(new Student(245, "Rohit Sharma", 24));
        arraylist.add(new Student(209, "Sachin Tendulkar", 32));
        return arraylist;
    }


    public static void simpleSorting() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("NodeJs");
        list.add("Groovy");
        list.add("JavaScript");
        list.add("C Sharp");

        System.out.println("Unsorted ArrayList: " + list);

        Collections.sort(list);
        System.out.println("Sorted ArrayList in Ascending order : " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted ArrayList in Descending order : " + list);

        list.sort(Collections.reverseOrder());
        System.out.println("Alternate way Sorted ArrayList in Descending order : " + list);

    }
}

