package com.mukul.smallprograms;

/*
Problem: In this problem, we would have an unordered array with consecutive distinct natural numbers [1,2,3,..n], where n is the size of the array.
         We have to find the minimum number of swaps required to sort the array in ascending order.

Solution: This problem can be solved easily by observing the actual position of elements and their current position , the actual position of element in sorted array will be the             a[cur]-1 (element-1), by tracking the actual position of element if we come back to the current element then there exist a cycle , then count the size of that cycle ,             the number of swaps will be cycling size-1, do this for all the cycles and add them together.
 */

public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int swap=0;
        boolean[] visited =new boolean[arr.length];

        for(int i=0;i<arr.length;i++){
            int j=i,cycle=0;

            while(!visited[j]){
                visited[j]=true;
                j=arr[j]-1;
                cycle++;
            }

            if(cycle!=0)
                swap+=cycle-1;
        }
        return swap;
    }

    public static void main(String[] args) {
        int[] arr ={1,3,2,4,6,5};
        int res = minimumSwaps(arr);
        System.out.println("Minimum Swaps Required: "+res);
    }
}
