package com.tuf.dsa;

import com.tuf.dsa.arrays.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntersactionSortedArray {
    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6);
        List<Integer> arr2 = Arrays.asList(2, 3, 3, 5, 6, 6, 7);
        List<Integer> intersactionArray = new ArrayList<>();

        //intersactionArray = intersactionBruteApproach(arr1, arr2);
        intersactionArray = intersaction(arr1,arr2);
        //intersactionArray = intersectionJava8(arr1,arr2);
        ArrayUtil.print(intersactionArray);
    }

    private static List<Integer> intersactionBruteApproach(List<Integer> arr1, List<Integer> arr2) {

        List<Integer> result = new ArrayList<>(Math.max(arr1.size(), arr2.size()));
        List<Integer> visited = new ArrayList<>(Collections.nCopies(arr2.size(), 0));
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {

                if (arr1.get(i) == arr2.get(j) && visited.get(j) == 0) {
                    result.add(arr2.get(j));
                    visited.set(j, 1);
                    break;
                }
                if (arr2.get(j) > arr1.get(i)) {
                    break;
                }
            }
        }
        return result;
    }

    private static List<Integer> intersaction(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> results = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                i++;
            } else if (arr2.get(j) < arr1.get(i)) {
                j++;
            }else {
                results.add(arr1.get(i));
                i++;
                j++;
            }
        }
        return results;
    }

    private static List<Integer> intersectionJava8(List<Integer> arr1, List<Integer> arr2) {
        // Use Java 8 Stream to find intersection using two-pointer technique
        return arr1.stream()
                .filter(arr2::contains)
                //.distinct() // Ensure no duplicate entries
                .collect(Collectors.toList());
    }
}
