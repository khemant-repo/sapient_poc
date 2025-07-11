package com.preprations.innerclass.annonymousclass;

import java.util.*;

public class ComparatorExampleWithNamedClass {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Christopher", "Dave");

        Collections.sort(names, new LengthComparator());

        System.out.println("Sorted by length: " + names);
    }
}

// Named Comparator class
class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}
