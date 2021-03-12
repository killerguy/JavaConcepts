package com.mukul.sorting;

import java.util.Comparator;

public class SortByRollNumber implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getRollNo() > b.getRollNo() ? 1 : a.getRollNo() == b.getRollNo() ? 0 : -1;
    }
}
