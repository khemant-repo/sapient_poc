package com.java8.streams.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 	Sort the given list of decimals in reverse order?
 * a.	Input: List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
 * b.	Output: 71.85 56.98 42.89 33.78 23.58 21.12 17.13 12.45
 */
public class SortNumbersInReverseOrder {
    public static void main(String[] args) {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        
        var result  = decimalList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(toList());

        System.out.println("result = " + result);
    }
}
