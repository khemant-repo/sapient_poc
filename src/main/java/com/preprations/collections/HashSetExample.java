package com.preprations.collections;

import java.util.HashSet;

/**
 * HashSet – Unordered, no duplicates
 * Best Use Case: Ensure uniqueness of elements, like storing user IDs or emails.
 */
public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        // Create
        emails.add("alice@example.com");
        emails.add("bob@example.com");
        emails.add("alice@example.com"); // Duplicate — will be ignored

        // Read
        System.out.println("Emails: " + emails);
        System.out.println("Contains bob@example.com? " + emails.contains("bob@example.com"));

        // Delete
        emails.remove("alice@example.com");
        System.out.println("After deletion: " + emails);
    }
}
