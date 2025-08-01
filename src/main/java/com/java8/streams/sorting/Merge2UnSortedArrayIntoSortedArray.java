package com.java8.streams.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Question:Merge two unsorted arrays into single sorted array using Java 8 streams.
 * a.	Input:
 * i.	Int[] a = new int[] {4, 2, 7, 1};
 * ii.	int[] b = new int[] {8, 3, 9, 5};
 * b.	Output: [1, 2, 3, 4, 5, 7, 8, 9]
 */
public class Merge2UnSortedArrayIntoSortedArray {
    public static void main(String[] args) {
        int[] a = {4, 2, 7, 1};
        int[] b = {8, 3, 9, 5,1};

        mergeAndSort(a, b);
        mergeAndSortWithoutDuplicate(a, b);

    }

    private static void mergeAndSortWithoutDuplicate(int[] a, int[] b) {
        var result = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).distinct().sorted().toArray();
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        
    }

    private static void mergeAndSort(int[] a, int[] b) {
        var result = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .sorted()
                .toArray();
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
