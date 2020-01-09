package com.mukul.java8features.lambdas.streams.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestCheckedException {

    public static <T,R> Function<T,R> wrap(CheckedFunction<T,R> checkedFunction) {
        return t -> {
            try {
                System.out.println(t);
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("100");
        myList.add("200");
        myList.add("300");
        myList.add("400a");

        myList.stream()
                .map(wrap(item -> doSomething(item)))
                .forEach(System.out::println);

        System.out.println("Finished !!");
    }

    public static String doSomething(String a){
                int i = Integer.parseInt(a);
                return "Successful";

    }

}
