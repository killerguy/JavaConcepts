package com.mukul.smallprograms;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome("123456"));
        System.out.println(isPalindrome("12121"));

    }

    private static boolean isPalindrome(String data) {

        if (isSingleChar(data)) {
            return true;
        } else {
            if (isFirstAndLastCharIsSame(data)) {
                return isPalindrome(data.substring(1, data.length() - 1));
            } else {
                return false;
            }

        }
    }

    private static boolean isFirstAndLastCharIsSame(String data) {
        return data.charAt(0) == data.charAt(data.length() - 1);
    }

    private static boolean isSingleChar(String data) {
        return data.length() == 0 || data.length() == 1;
    }


}
