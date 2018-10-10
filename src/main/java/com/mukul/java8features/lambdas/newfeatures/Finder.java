package com.mukul.java8features.lambdas.newfeatures;

/**
 * A functional interface
 */

public class Finder {

    @FunctionalInterface
    public interface IFinder {

        /**
         * An abstract method
         *
         * @return
         * @paramfind
         */
        String find(String criteria);

        default String criteria() {
            return "Search criteria:";
        }
    }

    public static void main(String[] args) {
        IFinder finder = (s) -> "result";
    }
}
