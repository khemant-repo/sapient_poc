package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * question: find maximum and minimum of those numbers?
 * a.	Input: List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
 * b.	Output : Maximum Element : 89, Minimum Element : 12
 */
public class FilterGivenElement {
    
    public static void main(String[] args) {
        printNumberMultipleOf5();
        List<Integer> numbers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        var max = numbers.stream()
                .max(Comparator.comparing(n-> n));
        System.out.println("max = " + max);

        numbers.stream()
                .min(Comparator.naturalOrder()).ifPresent(min-> System.out.println("min: "+min));
    }

    private static void printNumberMultipleOf5() {
        List<Integer> numbers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        var result = numbers.stream().filter(n-> n%5==0).collect(Collectors.toList());

        System.out.println("result = " + result);
    }
}
