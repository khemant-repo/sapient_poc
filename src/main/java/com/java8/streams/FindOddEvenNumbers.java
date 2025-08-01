package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * question: Given a list of integers, separate odd and even numbers?
 * a.	Input: List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21)
 * b.	Output: Odd Number : 71 21, Even Numbers : 18 42
 */
public class FindOddEvenNumbers {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21);
        
        var result = listOfIntegers.stream()
                .collect(Collectors.partitioningBy(n->n%2==0 ));
        System.out.println("result = " + result);
        List<Integer> oddNumber = result.get(false);
        System.out.println("oddNumber = " + oddNumber);
        List<Integer> evenNumber = result.get(true);
        System.out.println("evenNumber = " + evenNumber);
        
    }
}
