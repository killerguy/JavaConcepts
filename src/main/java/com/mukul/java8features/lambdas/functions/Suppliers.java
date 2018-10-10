package com.mukul.java8features.lambdas.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Class for Supplier's functionality
 */
public class Suppliers {

    /**
     * A supplier of soft drinks
     */

    Supplier<List<String>> drinksSupplier = () -> {
        List<String> drinks = new ArrayList<String>();

        drinks.add("Orange Juice");
        drinks.add("Pineapple");
        drinks.add("Custard Apple");

        return drinks;
    };

    public void getDrinks() {
        List<String> softDrinks = drinksSupplier.get();
        softDrinks.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Suppliers().getDrinks();
    }

}
