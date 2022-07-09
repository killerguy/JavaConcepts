package com.mukul;

public class TestClass {

    public static void main(String[] args) {
     test();
    }
    public static void test(){
        Integer a = 100;
        Integer b = 100;
        System.out.println(a==b);
        a = 1000;
        b = 1000;
        System.out.println(a==b);
    }
}
