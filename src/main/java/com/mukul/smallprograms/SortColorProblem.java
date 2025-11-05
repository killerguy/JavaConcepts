package com.mukul.smallprograms;

import java.util.Arrays;

/**
 * Sort Colors (Dutch National Flag) problem.
 *
 * <p>Given an array nums with n objects colored 0 (red), 1 (white), or 2 (blue),
 * sort them in-place so that objects of the same color are adjacent, with the
 * colors in the order red, white and blue. The solution below implements the
 * one-pass algorithm using three pointers (low, mid, high) and only constant
 * extra space.</p>
 *
 * <p>Algorithm (one-pass):
 * - Maintain three pointers: low (position for next 0), mid (current element),
 *   and high (position for next 2).
 * - Iterate while mid <= high:
 *   - If nums[mid] == 0: swap(nums[low], nums[mid]); low++; mid++
 *   - Else if nums[mid] == 1: mid++
 *   - Else (nums[mid] == 2): swap(nums[mid], nums[high]); high-- (do not increment mid)
 * This partitions the array into [0..low-1]=0, [low..mid-1]=1, [mid..high]=unknown, [high+1..end]=2.
 *
 * Time complexity: O(n) — each element is moved at most once.
 * Space complexity: O(1) extra space (in-place).
 *</p>
 *
 * Examples:
 * Input: [2,0,2,1,1,0] -> Output: [0,0,1,1,2,2]
 * Input: [2,0,1] -> Output: [0,1,2]
 */
public class SortColorProblem {

    /**
     * Sorts the array in-place so that all 0s come first, then 1s, then 2s.
     *
     * @param nums array of integers containing only 0, 1, or 2
     * @throws NullPointerException if nums is null
     */
    public static void sortColors(int[] nums) {
        if (nums == null) throw new NullPointerException("Input array cannot be null");
        int low = 0;              // next position for 0
        int mid = 0;              // current element under consideration
        int high = nums.length - 1; // next position for 2

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
                default:
                    throw new IllegalArgumentException("Array can only contain 0, 1, or 2. Found: " + nums[mid]);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Small demo runner with the examples from the prompt.
     */
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        System.out.println("Before: " + Arrays.toString(nums1));
        sortColors(nums1);
        System.out.println("After : " + Arrays.toString(nums1));

        int[] nums2 = {2, 0, 1};
        System.out.println("Before: " + Arrays.toString(nums2));
        sortColors(nums2);
        System.out.println("After : " + Arrays.toString(nums2));
    }
}
