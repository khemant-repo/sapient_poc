package com.preprations.multithreading;

import java.util.concurrent.*;

public class ExecutionExceptionExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1/0;
            }
        };

       Future<Integer> future = executorService.submit(task);

        try {
            int result = future.get();
            System.out.println("result: "+result);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        } catch (ExecutionException e) {
            System.out.println("Caught ExecutionException:");
            System.out.println("Cause: " + e.getCause()); // Get original exception
        }finally {
            executorService.shutdown();
        }

    }


}
