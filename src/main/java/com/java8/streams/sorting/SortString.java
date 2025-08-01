package com.java8.streams.sorting;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * sort given string in ascending order
 */
public class SortString {
    public static void main(String[] args) {
        String str = "hhhtttbbbaaa";
        String result = str.chars()// convert string to chars : return IntStream
                .mapToObj(c-> (char) c) // convert int to char(eg: 104 = 'h')
                .sorted()// sort characters
                .map(String::valueOf) // convert characters to string
                .collect(Collectors.joining()); //// join all characters to string

        System.out.println("result = " + result);

        //approach 2
        var result2 = Stream.of(str.split("")).sorted().collect(Collectors.joining());
        System.out.println("result2 = " + result2);
    }
}
