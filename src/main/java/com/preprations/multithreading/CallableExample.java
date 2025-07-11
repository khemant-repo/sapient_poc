package com.preprations.multithreading;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {

        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("count no. of people");
                return 12;
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(task);
        System.out.println(result.get() +  " people are in hall");
        executorService.shutdown();
    }
}
