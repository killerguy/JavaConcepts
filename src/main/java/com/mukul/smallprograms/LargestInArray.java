package com.mukul.smallprograms;

import java.util.PriorityQueue;

/**
 * Simplified utilities to find the k-th largest element.
 * - Quickselect: average O(n) time, O(1) extra space
 * - Min-heap: O(n log k) time, O(k) space
 */
public class LargestInArray {

    public static int findKthLargestUsingHeap(int[] nums, int k) {
        if (nums == null) throw new NullPointerException("nums is null");
        int n = nums.length;
        if (k < 1 || k > n) throw new IllegalArgumentException("k out of range");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : nums) {
            pq.offer(v);
            if (pq.size() > k) pq.poll();
        }
        Integer top = pq.peek();
        if (top == null) throw new IllegalStateException("Heap is empty after processing input");
        return top;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println("k=2 -> " + findKthLargestUsingHeap(a, 2)); // expected 5

        int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("k=4 -> " + findKthLargestUsingHeap(b, 4)); // expected 4


    }
}
