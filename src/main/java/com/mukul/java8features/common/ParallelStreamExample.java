package com.mukul.java8features.common;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamExample {

/*
 - Streams can be executed in parallel to increase runtime performance on large amount of input elements.
 - Parallel streams use a common ForkJoinPool available via the static ForkJoinPool.commonPool() method.
 */

    public static void main(String[] args) {
        ParallelStreamExample parallelStreamExample = new ParallelStreamExample();
        parallelStreamExample.getStreamCommonPool();
        parallelStreamExample.getParallelExecutionBehavior();

    }

    /* On my machine the common pool is initialized with a parallelism of 3 per default.
       This value can be decreased or increased by setting the following JVM parameter:
       -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
    */
    private void getStreamCommonPool() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("Common-Pool: " + commonPool.getParallelism());
    }


    private void getParallelExecutionBehavior() {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));
    }

}
