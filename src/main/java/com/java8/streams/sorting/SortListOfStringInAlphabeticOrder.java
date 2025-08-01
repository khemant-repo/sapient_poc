package com.java8.streams.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * sort the list of strings in alphabetical order using Java Stream API.
 * a.	Input: List<String> strings = Arrays.asList("banana", "orange", "apple", "grape");
 * b.	Output: Sorted strings: [apple, banana, grape, orange]
 */
public class SortListOfStringInAlphabeticOrder {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("banana", "orange", "apple", "grape");
        var result = strings.stream().sorted().collect(Collectors.toList());
        System.out.println("result = " + result);
        
    }
}
