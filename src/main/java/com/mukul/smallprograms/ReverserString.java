package com.mukul.smallprograms;

public class ReverserString {

    public static void main(String[] args) {

        System.out.println(reverse("Mukul".toCharArray(),0,"Mukul".length()-1));
    }

    public static String reverse(char src[],int start,int end) {
        String data = "" ;
        if (start >= end) {
            System.out.println(new String(src));
            data= new String(src);
        } else {

            char temp = src[start];
            src[start] = src[end];
            src[end] = temp;

            reverse(src, ++start, --end);
        }
        return data;
    }
}
