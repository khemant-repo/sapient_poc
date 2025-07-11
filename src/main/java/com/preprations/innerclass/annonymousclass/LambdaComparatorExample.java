package com.preprations.innerclass.annonymousclass;

import java.util.*;

public class LambdaComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Christopher", "Dave");

        // Lambda expression for Comparator
        Collections.sort(names, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println("Sorted by length: " + names);
    }
}
