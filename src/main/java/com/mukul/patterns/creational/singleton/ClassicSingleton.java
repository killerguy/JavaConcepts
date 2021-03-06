package com.mukul.patterns.creational.singleton;

public class ClassicSingleton {

    // define an instance field
    private static ClassicSingleton instance;

    // make constructor private
    private ClassicSingleton() {
    }

    // use static method to return instance
    public static ClassicSingleton getInstance() {
        // lazy initialization
        if (instance == null) {
            instance = new ClassicSingleton();
        }
        return instance;
    }
}
