package com.java8.streams.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Find second largest number in an integer array?
 * a.	Input: List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
 * b.	Output: 75
 */
public class FindSecondLargestElement {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(45);
        var result = listOfIntegers.stream()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst();
        result.ifPresent(n-> System.out.println("result = " + n));
       // System.out.println("result = " + );
    }
}
