package com.mukul.java7features;

public class SwitchStringExample {
    public static void main(String[] args) {
        printColorUsingSwitch("red");
        printColorUsingIf("blue");
        printColorUsingIf("red");
        // switch case string is case-sensitive
        printColorUsingSwitch("RED");
        //  printColorUsingSwitch(null);
    }

    private static void printColorUsingIf(String color) {
        if (color.equals("blue")) {
            System.out.println("BLUE");
        } else if (color.equals("red")) {
            System.out.println("RED");
        } else {
            System.out.println("INVALID COLOR CODE");
        }
    }

    private static void printColorUsingSwitch(String color) {
        switch (color) {
            case "blue":
                System.out.println("BLUE");
                break;
            case "red":
                System.out.println("RED ");
                break;
            default:
                System.out.println("INVALID COLOR CODE");
        }
    }

}

//Switch case uses String.equals() method to compare the passed value with case values, so make sure to add a NULL check to avoid NullPointerException.
