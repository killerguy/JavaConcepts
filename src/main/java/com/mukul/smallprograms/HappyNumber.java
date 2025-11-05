package com.mukul.smallprograms;

public class HappyNumber {

   /* public static boolean isHappy(int n) {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }*/
   public static boolean isHappy(int n) {
       if (n <= 1) return n == 1;
       int slow = getSumOfSquares(n);
       int fast = getSumOfSquares(slow);
       while (fast != 1 && slow != fast) {
           slow = getSumOfSquares(slow);
           fast = getSumOfSquares(getSumOfSquares(fast));
       }
       return fast == 1;
   }
    /*
    *
    *
    * */

    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));  // true
        System.out.println(isHappy(2));   // false
    }
}
