package com.mukul.java8features.common;

interface Calculator {
    void switchOn();
}

public class AnonymousExample {
    Calculator calculator = () -> {
        System.out.println("Calculator Switched On");
    };

    public static void main(String[] args) {
        AnonymousExample anonymousExample = new AnonymousExample();
        anonymousExample.calculator.switchOn();
    }
}
