package com.mukul.smallprograms;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrimeUsingRecursion(17, 2));
        System.out.println(isPrime(9));
    }

    private static boolean isPrime(int nunber) {
        int count = 0;
        for (int i = 1; i < nunber; i++) {
            if (nunber % i == 0) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }

    }

    private static int isPrimeUsingRecursion(int number, int i) {
        if (i < number) {
            if (number % i != 0) {
                return isPrimeUsingRecursion(number, ++i);
            } else {
                return 0;
            }
        }
        return 1;
    }


}
