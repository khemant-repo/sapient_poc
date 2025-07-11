package com.preprations.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creates a single thread executor.
 * All tasks are executed sequentially in one background thread.
 * Useful for logging, audit, or background task processing where order matters
 */
public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 3; i++){
            int taskId = i;
            executorService.submit(()-> System.out.println("Task "+ taskId +" Executed by Thread "+Thread.currentThread().getName()));
            System.out.println();
        }

        executorService.shutdown();
    }
}
