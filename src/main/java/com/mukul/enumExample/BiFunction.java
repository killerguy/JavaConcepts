package com.mukul.enumExample;

public class BiFunction{

    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(5,5));
        System.out.println(Operation.SUBTRACT.apply(5,5));
        System.out.println(Operation.MULTIPLY.apply(5,5));
        System.out.println(Operation.DIVIDE.apply(5,5));
    }


}
