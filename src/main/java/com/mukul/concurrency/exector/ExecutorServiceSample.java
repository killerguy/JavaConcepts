package com.mukul.concurrency.exector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {

    // Simulated method to call an external service
    private String callExternalService(String value) {
        return value + value; // Simulated response
    }

    public List<String> callServices(List<String> values) {
        ExecutorService executorService = Executors.newFixedThreadPool(5); // Create a fixed thread pool
        List<Future<String>> futures = new ArrayList<>();

        // Submit tasks to the executor
        for (String value : values) {
            Callable<String> task = () -> callExternalService(value);
            Future<String> future = executorService.submit(task);
            futures.add(future);
        }

        List<String> responses = new ArrayList<>();
        // Wait for all tasks to complete and collect responses
        for (Future<String> future : futures) {
            try {
                responses.add(future.get()); // Blocking call, waits for the result
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace(); // Handle exceptions appropriately
            }
        }

        executorService.shutdown(); // Shutdown the executor service
        return responses;
    }

    public static void main(String[] args) {
        ExecutorServiceSample caller = new ExecutorServiceSample();
        List<String> values = Arrays.asList("Value1", "Value2", "Value3", "Value4", "Value5");
        List<String> responses = caller.callServices(values);

        // Print the responses
        for (String response : responses) {
            System.out.println(response);
        }
    }
}