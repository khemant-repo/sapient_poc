package com.preprations.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Use when:
 * You have many lightweight tasks and you don’t care about thread limits
 */
public class CachedThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++){
            int taskId = i;
            executorService.submit(()-> System.out.println("Task "+ taskId +" Executed by Thread "+Thread.currentThread().getName()));
            System.out.println();
        }

        executorService.shutdown();
    }
}
