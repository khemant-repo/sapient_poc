package com.preprations.multithreading;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "Future result";
        };

        System.out.println("Submitting task to executor...");
        Future<String> future = executor.submit(task);

        // Simulate doing something else
        System.out.println("Doing other work while task executes...");

        // Blocking call
        String result = future.get(); // blocks until result is available
        System.out.println("Result from Future: " + result);

        executor.shutdown();
    }
}
