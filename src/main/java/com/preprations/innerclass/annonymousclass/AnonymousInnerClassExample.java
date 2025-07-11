package com.preprations.innerclass.annonymousclass;

import java.util.*;

public class AnonymousInnerClassExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Christopher", "Dave");

        // Anonymous inner class used directly as a Comparator
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        System.out.println("Sorted by length: " + names);
    }
}
