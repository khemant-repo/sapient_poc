package com.tuf.dsa;

import java.util.*;

public class SubarraySum20 {

    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 17, 9, 15, 3};
        int targetSum = 20;

        findSubarraysWithSum(arr, targetSum);
    }

    public static void findSubarraysWithSum(int[] arr, int targetSum) {
        System.out.println("Subarrays with sum " + targetSum + ":");

        // Brute-force: check all subarrays
        for (int start = 0; start < arr.length; start++) {
            int sum = 0;
            for (int end = start; end < arr.length; end++) {
                sum += arr[end];
                if (sum == targetSum) {
                    printSubarray(arr, start, end);
                }
            }
        }
    }

    private static void printSubarray(int[] arr, int start, int end) {
        System.out.print("[ ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
