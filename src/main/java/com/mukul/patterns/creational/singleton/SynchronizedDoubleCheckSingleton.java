package com.mukul.patterns.creational.singleton;

public class SynchronizedDoubleCheckSingleton {

    private static volatile SynchronizedDoubleCheckSingleton instance;

    private SynchronizedDoubleCheckSingleton() {
    }

    public static SynchronizedDoubleCheckSingleton getInstance() {
        // only acquire lock after checking instance
        if (instance == null) {
            synchronized (SynchronizedBlockSingleton.class) {
                // Other threads may already create the object
                if (instance == null) {
                    instance = new SynchronizedDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
