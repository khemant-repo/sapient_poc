package com.preprations.collections;

import java.util.TreeSet;

/**
 * TreeSet – Sorted, no duplicates (Red-Black Tree)
 * Best Use Case: When sorted, unique collection is needed (e.g., leaderboard rankings).
 */
public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        // Create
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(30); // Duplicate ignored

        // Read
        System.out.println("Sorted Set: " + numbers);
        System.out.println("First: " + numbers.first() + ", Last: " + numbers.last());

        // Delete
        numbers.remove(10);

        System.out.println("After removal: " + numbers);
    }
}
