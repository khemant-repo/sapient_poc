package com.java8.streams.string;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *      Find frequency of each character in a string using Java 8 streams?
 * a.	Input:  String inputString = "Java Concept Of The Day";
 * b.	Output: { =4, a=3, c=1, C=1, D=1, e=2, f=1, h=1, J=1, n=1, O=1, o=1, p=1, T=1, t=1, v=1, y=1}
 */
public class FrequencyOfEachCharacter {
    public static void main(String[] args) {
        String inputString = "Java Concept Of The Day";
        var result = Stream.of(inputString.split("")).collect(Collectors.groupingBy(i->i , Collectors.counting()));
        System.out.println("result = " + result);

        //approach 2
        var result1 = Stream.of(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("result1 = " + result1);
    }
}
