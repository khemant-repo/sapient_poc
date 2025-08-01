package com.tuf.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateFromArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 3, 1);

        System.out.println("Actual Array..");
        ArrayUtil.print(list);

        List<Integer> uniqueList = brute(list);

        System.out.println("After Removing Duplicate Elements..");
        ArrayUtil.print(uniqueList);

    }

    private static List<Integer> brute(List<Integer> list) {
        //List<Integer> uniqueElements = new ArrayList<>();
       return list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());

    }
}
