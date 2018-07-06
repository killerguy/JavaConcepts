package com.mukul.java5features;

public class BoxingBeatWidening {

    static void printInteger(Integer... i) {
        System.out.println("Integer...");
    }

    static void printInteger(Integer i) {
        System.out.println("Integer");
    }

    public static void main(String args[]) {
        int a = 30;
        printInteger(a);

    }
}
