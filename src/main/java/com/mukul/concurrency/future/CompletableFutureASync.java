package com.mukul.concurrency.future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureASync {

    public static void main(String[] args) throws Exception {

        Resource resource = new Resource();

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> resource.task1())
                .thenApplyAsync(result1 -> resource.task2(result1))
                .thenApplyAsync(result2 -> resource.task3(result2))
                .thenApplyAsync(result3 -> resource.task4(result3))
                .thenApplyAsync(result4 -> resource.task5(result4));


        stringCompletableFuture.get();

    }

    static class Resource {

        public String task1() {
            System.out.println("Resource.Task1-Started");
            System.out.println("Resource.Task1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Resource.Task1-Ended");
            return "Task1 Completed";
        }


        public String task2(String future) {
            System.out.println("Resource.Task2-Started");

            System.out.println(future + "\nResource.Task2-Ended");
            return "Task2 Completed";
        }

        public String task3(String future) {
            System.out.println("Resource.Task3-Started");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(future + "\nResource.Task3-Ended");
            return "Task3 Completed";
        }


        public String task4(String future) {
            System.out.println("Resource.Task4-Started");

            System.out.println(future + "\nResource.Task4-Ended");
            return "Task4 Completed";
        }

        public String task5(String future) {
            System.out.println("Resource.Task5-Started");

            System.out.println(future + "\nResource.Task5-Ended");
            return "Task5 Completed";
        }
    }
}
