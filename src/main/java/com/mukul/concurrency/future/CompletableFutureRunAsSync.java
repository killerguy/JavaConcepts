package com.mukul.concurrency.future;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
class SharedResource {
    private int value;
    private final AtomicInteger atomicInteger = new AtomicInteger(4);

    public void incrementValue() {
        value += 2; // Increment the value by 2
    }

}

public class CompletableFutureRunAsSync {
    private static final SharedResource sharedResource = new SharedResource();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> accessSharedResource(1));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> accessSharedResource(2));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.get(); // Wait for both futures to complete

        System.out.println("Final value: " + sharedResource.getValue());
        System.out.println("-------------------------------------------------");

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> sharedResource.getAtomicInteger().incrementAndGet());
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> sharedResource.getAtomicInteger().incrementAndGet());

         CompletableFuture.allOf(future3,future4).get();
        System.out.println("Final value: " + sharedResource.getAtomicInteger());


    }

    private static synchronized void accessSharedResource(int threadId) {
        // Simulate some processing
        System.out.println("Thread " + threadId + " is executing the operation.");
        sharedResource.incrementValue(); // Increment the value by 2
    }
}
