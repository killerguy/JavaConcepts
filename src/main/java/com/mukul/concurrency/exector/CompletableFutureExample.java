package com.mukul.concurrency.exector;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    // Simulated external service call
    public static String callExternalService(String input) {
        try {
            // Simulating a delay for the external service call
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Result for " + input;
    }

    public static void main(String[] args) {
        // Create an array of input values
        String[] inputs = {"Value1", "Value2", "Value3"};

        // Create an array of CompletableFutures
        CompletableFuture<String>[] futures = new CompletableFuture[inputs.length];

        // Initiate calls to the external service
        for (int i = 0; i < inputs.length; i++) {
            final String input = inputs[i];
            futures[i] = CompletableFuture.supplyAsync(() -> callExternalService(input));
        }

        // Wait for all futures to complete and collect results
        for (int i = 0; i < futures.length; i++) {
            try {
                // Get the result of each future
                String result = futures[i].get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}