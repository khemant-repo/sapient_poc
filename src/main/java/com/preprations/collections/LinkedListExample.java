package com.preprations.collections;

import java.util.LinkedList;

/**
 * LinkedList – Ordered, allows duplicates, good for insert/delete in middle
 * Best Use Case: When frequent inserts/removals from middle of list are needed.
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();

        // Create (Add)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.addFirst("Mango"); // Add at beginning
        fruits.addLast("Grapes");

        // Read
        System.out.println("Fruits: " + fruits);
        System.out.println("First fruit: " + fruits.getFirst());

        // Update
        fruits.set(1, "Mango");

        // Delete
       // fruits.removeLast();


        System.out.println("Updated Fruits: " + fruits);
    }
}
