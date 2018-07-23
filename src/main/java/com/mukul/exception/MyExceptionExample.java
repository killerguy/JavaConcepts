package com.mukul.exception;

public class MyExceptionExample {

    public static void main(String[] a) {
        try {
            MyExceptionExample.myTest(null);
        } catch (MyAppCustomException exception) {
            System.out.println("Inside catch block: " + exception.getMessage());
        }
    }

    private static void myTest(String str) throws MyAppCustomException {
        if (str == null) {
            throw new MyAppCustomException("String val is null");
        }
    }
}


