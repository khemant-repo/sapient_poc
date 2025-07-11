package com.tuf.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,5,6,2,4,1,6,9,7,2);
        Set<Integer> duplicateNumbers =    getDuplicatebyFreq(numbers);

        for (Integer n : duplicateNumbers){
            System.out.print(n+" ");
        }
        System.out.println("unique elements");
        List<Integer> uniqueNumbers =  removeDuplicateElement(numbers);
        ArrayUtil.print(uniqueNumbers);
    }

    private static List<Integer> removeDuplicateElement(List<Integer> numbers) {

        return   numbers.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());

    }

    private static Set<Integer> getDuplicatebyFreq(List<Integer> numbers) {

        return  numbers.stream()
                .filter(n -> Collections.frequency(numbers,n) >1)
                .collect(Collectors.toSet());

    }
}
