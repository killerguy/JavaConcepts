package com.mukul.threads.runnable;

public class RunnableExampleLambdaExpression {

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        Runnable runnable = () -> {
            System.out.println("Inside " + Thread.currentThread().getName());
        };

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);
        thread.setName("Thread-Stream");

        System.out.println("Starting Thread...");
        thread.start();
    }
}