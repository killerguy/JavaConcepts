package com.mukul.smallprograms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInArrayWithRecursion {

    public static int find(int[] elements, int k) {

        Queue<Integer> queue = new PriorityQueue<>();
        for (int element : elements) {
            queue.offer(element);
        }


        return findKthSmallestElement(k, queue, -1);
    }

    private static int findKthSmallestElement(int k, Queue<Integer> queue, int dataToBeReturn) {
        if (k > 0) {
            int k1 = --k;
            System.out.println(k1);
            System.out.println(queue);
            Integer poll = queue.poll();
            System.out.println("Pol " + poll);

            int kthSmallestElement = findKthSmallestElement(k1, queue, poll);
            System.out.println("-- "+kthSmallestElement);
            return kthSmallestElement;
        } else {
            return dataToBeReturn;
        }
    }

    public static void main(String[] args) {
        int[] elements = {15, 10, 20, 40, 3, 5, 3, 2, 32, 44, 51, 6};
        System.out.println("4th smallest element with recursion:" + find(elements, 4));

        Arrays.sort(elements);
        System.out.println("4th smallest element with sorting:" + elements[0]);


    }
}
