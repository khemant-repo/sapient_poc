package com.tuf.dsa.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        //findDuplicateNumbers();
        List<Integer> numbers = Arrays.asList(1,2,4,3,2,1,5);
       Set<Integer> unique=  numbers.stream().distinct().collect(Collectors.toSet());

        System.out.printf("unique"+unique);
    }

    private static void findDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1,2,4,3,2,1,5);
        Set<Integer> duplicateNumbers = numbers.stream().filter(n -> Collections.frequency(numbers,n)>1)
                .collect(Collectors.toSet());
        System.out.printf("duplicateNumbers"+duplicateNumbers);
    }
}
