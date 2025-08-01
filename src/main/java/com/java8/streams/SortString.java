package com.java8.streams;

import java.util.stream.Collectors;

/**
 * sort given string in ascending order
 */
public class SortString {
    public static void main(String[] args) {
        String str = "hhhtttbbbaaa";
        String result = str.chars()
                .mapToObj(c-> (char) c)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("result = " + result);
    }
}
