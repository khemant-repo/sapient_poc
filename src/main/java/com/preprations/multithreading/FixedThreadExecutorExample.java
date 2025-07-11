package com.preprations.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Use when:
 * You have a known number of threads to handle concurrent tasks (e.g., 5 REST calls simultaneously)
 */
public class FixedThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++){
            int taskId = i;
            executorService.submit(()-> System.out.println("Task "+ taskId +" Executed by Thread "+Thread.currentThread().getName()));
            System.out.println();
        }

        executorService.shutdown();
    }
}
