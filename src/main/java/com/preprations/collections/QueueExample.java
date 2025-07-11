package com.preprations.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue (LinkedList as Queue) – FIFO
 * Best Use Case: Task scheduling, order processing.
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();

        // Create
        tasks.add("a");
        tasks.offer("Task1");
        tasks.offer("Task2");
        tasks.offer("Task3");

        // Read + Remove (FIFO)
        System.out.println("Next task: " + tasks.poll());
        System.out.println("Remaining: " + tasks);
    }
}
