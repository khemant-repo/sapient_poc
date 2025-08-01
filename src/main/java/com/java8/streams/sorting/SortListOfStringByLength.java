package com.java8.streams.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 17.	Given a list of strings, sort them according to increasing order of their length?
 * a.	Input:  List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
 * b.	Output: C C# C++ Java HTML COBOL Python Kotlin
 */
public class SortListOfStringByLength {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        var result  = listOfStrings.stream().sorted((s1,s2)-> s1.length() - s2.length()).collect(Collectors.toList());
        System.out.println("result = " + result);

        //approach 2
        var result2  = listOfStrings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("result2 = " + result2);
        
    }
}
