package com.java8.streams.sorting;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  check if two strings are anagrams or not?
 * a.	Input:  String s1 = "RaceCar";     String s2 = "CarRace";
 * b.	Output: Two strings are anagrams
 */
public class AnagramString {
    public static void main(String[] args) {
        String s1 = "RaceCaR";
        String s2 = "CarRace";

        var result1 = Stream.of(s1.split("")) // split
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining());
        System.out.println("result1 = " + result1);
        
        var result2 =  Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        System.out.println("result2 = " + result2);
        
        String r = result1.equals(result2) ? "Anagram": "Not Anagram";
        System.out.println("Given Strings are: "+ r);

    }
}
