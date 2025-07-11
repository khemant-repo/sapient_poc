package com.preprations.multithreading;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class WorkStealingExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService workStealingPool = Executors.newWorkStealingPool(); // uses ForkJoinPool

        List<Callable<String>> tasks = IntStream.range(1, 6)
                .mapToObj(i -> (Callable<String>) () -> {
                    Thread.sleep(1000); // simulate delay
                    String result = "Task " + i + " executed by " + Thread.currentThread().getName();
                    System.out.println(result);
                    return result;
                })
                .toList();

        List<Future<String>> results = workStealingPool.invokeAll(tasks);

        for (Future<String> f : results) {
            f.get(); // trigger exceptions if any
        }

        workStealingPool.shutdown();
    }
}
