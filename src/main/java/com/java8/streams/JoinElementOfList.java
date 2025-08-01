package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
 * a.	Input: List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
 * b.	Output: [Facebook, Twitter, YouTube, WhatsApp, LinkedIn]
 */
public class JoinElementOfList {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        var result  = listOfStrings
                .stream().collect(Collectors.joining(",","[","]"));
        System.out.println("result = " + result);
    }

}
