package com.mukul.java8features.common;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToIntegerConversion {

    public static void main(String[] args) {

        convertMultiNumbersStringToIntegerArray();

        convertStringToPrimitiveInteger();

        convertStringToWrapperInteger();
    }

    private static void convertStringToWrapperInteger() {
        String stringNumber = "123";
        int integer = Integer.parseInt(stringNumber);
        System.out.println("Integer = " + integer);
    }

    private static void convertStringToPrimitiveInteger() {
        String stringNumber = "456";
        int primitive = Integer.parseInt(stringNumber);
        System.out.println("int = " + primitive);
    }

    private static void convertMultiNumbersStringToIntegerArray() {
        String numbers = "1,2,3,4,5,6";
        String separator = ",";
        Pattern pattern = Pattern.compile(separator);
        List<Integer> numberList = pattern.splitAsStream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        numberList.forEach(System.out::println);
        numberList.forEach(System.out::println);
    }

}
