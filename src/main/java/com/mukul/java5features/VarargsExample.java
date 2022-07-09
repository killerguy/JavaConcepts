package com.mukul.java5features;

class VarargsExample {

    static void display(String... values) {

        System.out.println("display method invoked ");

        for (String s : values) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        display();// zero argument
        System.out.println("*********************************************");

        display("hello");// one argument
        System.out.println("*********************************************");

        display("my", "name", "is", "varargs");// four arguments
        System.out.println("*********************************************");
    }
}
//