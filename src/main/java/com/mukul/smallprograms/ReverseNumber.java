package com.mukul.smallprograms;

public class ReverseNumber {

    public static void main(String[] args) {
        int number = 123456;

        reverse(number);
    }

    private static void reverse(int number) {

        if(number<10) {
            System.out.println(number);
            return;
        }
        System.out.print(number%10);
        reverse(number/10);
    }
}
