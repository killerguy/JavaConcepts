package com.mukul.smallprograms;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Demonstrates multiple ways to find duplicate elements in an array and documents the
 * time/space complexity of each approach.
 *
 * Approaches included:
 *  - bruteForce: double loop (O(n^2) time, O(1) extra space)
 *  - usingSet: HashSet to detect duplicates (O(n) time average, O(n) space)
 *  - usingSorting: sort then scan (O(n log n) time, O(n) or O(1) extra space depending on sort)
 *  - usingMap: frequency count (O(n) time, O(n) space)
 *  - findAnyDuplicateFloyd: Floyd's Tortoise and Hare for the special case where numbers are in
 *    the range 1..n-1 with exactly one duplicate (O(n) time, O(1) space)
 */
public class FindDuplicateArray {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 3, 6, 7, 8, 2};

        System.out.println("Input array: " + Arrays.toString(array));
        System.out.println();

        // Brute-force
        System.out.println("Brute force duplicates (may print each duplicate once):");
        Set<Integer> brute = duplicatesBruteForce(array);
        System.out.println(brute);
        System.out.println("Complexity: O(n^2) time, O(1) extra space");
        System.out.println("-------------------------------------");

        // Using HashSet (recommended general-purpose)
        System.out.println("Using HashSet (recommended):");
        Set<Integer> setBased = duplicatesUsingSet(array);
        System.out.println(setBased);
        System.out.println("Complexity: O(n) average time, O(n) space");
        System.out.println("-------------------------------------");

        // Using sorting
        System.out.println("Using sorting:");
        Set<Integer> sortedBased = duplicatesUsingSorting(array);
        System.out.println(sortedBased);
        System.out.println("Complexity: O(n log n) time, O(n) or O(1) extra space depending on sorting implementation");
        System.out.println("-------------------------------------");

        // Using frequency map
        System.out.println("Using frequency map (counts):");
        Set<Integer> mapBased = duplicatesUsingMap(array);
        System.out.println(mapBased);
        System.out.println("Complexity: O(n) time, O(n) space");
        System.out.println("-------------------------------------");

        // Floyd's algorithm example (works only when values are in 1..n-1 with at least one duplicate)
        System.out.println("Floyd's algorithm (special case 1..n-1) example:");
        int[] primitive = {1, 3, 4, 2, 2}; // example where Floyd applies
        int found = findAnyDuplicateFloyd(primitive);
        System.out.println("Found duplicate: " + found + " (or -1 if none or preconditions not met)");
        System.out.println("Complexity: O(n) time, O(1) space (only for special numeric constraints)");
    }

    /**
     * Brute-force: compare every pair. Collect duplicates into a set to avoid repeated outputs.
     */
    public static Set<Integer> duplicatesBruteForce(Integer[] array) {
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    duplicates.add(array[i]);
                }
            }
        }
        return duplicates;
    }

    /**
     * Using a HashSet: O(n) average time, O(n) additional space. This is the simplest and most
     * efficient general-purpose solution for arbitrary objects with properly implemented
     * equals()/hashCode().
     */
    public static Set<Integer> duplicatesUsingSet(Integer[] array) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (Integer num : array) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    /**
     * Sort the array (work on a copy to avoid mutating caller input) and scan for adjacent equal
     * elements. Time O(n log n), space O(n) because we copy the array here.
     */
    public static Set<Integer> duplicatesUsingSorting(Integer[] array) {
        Integer[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 1; i < copy.length; i++) {
            if (copy[i].equals(copy[i - 1])) {
                duplicates.add(copy[i]);
            }
        }
        return duplicates;
    }

    /**
     * Use a frequency map to count occurrences, then collect keys with count > 1. O(n) time,
     * O(n) space.
     */
    public static Set<Integer> duplicatesUsingMap(Integer[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer num : array) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /**
     * Floyd's Tortoise and Hare to find any duplicate number in an array where values are in the
     * range 1..n-1 and the array length is n (so at least one duplicate exists). Returns the
     * duplicate found, or -1 if not applicable.
     *
     * Note: This only works for that numeric constraint and finds one duplicate value.
     */
    public static int findAnyDuplicateFloyd(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        // Preconditions for Floyd: values must be in 1..n-1
        for (int v : nums) {
            if (v < 1 || v > nums.length - 1) return -1; // precondition not met
        }
        // Phase 1: find intersection
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        // Phase 2: find entrance to cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

}
