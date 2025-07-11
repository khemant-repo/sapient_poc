package com.preprations.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorLab {

    public static void main(String[] args) {
        // Step 1: Create ExecutorService with fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = new ArrayList<>();

        // Step 2: Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            MyTask task = new MyTask(i);
            Future<String> future = executor.submit(task);  // returns Future
            futures.add(future);
        }

        // Step 3: Retrieve results
        for (Future<String> future : futures) {
            try {
                String result = future.get();  // blocking call
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Step 4: Properly shutdown
        executor.shutdown();
    }
}
