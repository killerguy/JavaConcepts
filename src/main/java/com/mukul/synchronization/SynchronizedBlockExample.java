package com.mukul.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedBlockExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FineGrainedSynchronizedCounter counter = new FineGrainedSynchronizedCounter();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> counter.increment());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final count is " + counter.getCount());
    }
}

class FineGrainedSynchronizedCounter {
    private int count = 0;

    public void increment() {
        // Synchronized Block
        synchronized (this) {
            count = count + 1;
        }

    }

    public int getCount() {
        return count;
    }
}