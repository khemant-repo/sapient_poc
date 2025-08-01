package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *   Question: find frequency of each element in an array or a list?
 * a.	Input: List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
 * b.	Output: {Pen=2, Stapler=1, Pencil=2, Note Book=2, Eraser=1}
 */
public class FindFrequencyOfEachElement {
    public static void main(String[] args) {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        var result = stationeryList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("result = " + result);
    }
}
