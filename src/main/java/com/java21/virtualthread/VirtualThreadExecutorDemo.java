package com.java21.virtualthread;

import org.springframework.web.servlet.mvc.method.annotation.ContinuationHandlerMethodArgumentResolver;

import java.util.concurrent.*;

public class VirtualThreadExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 100_000; i++) {
            executor.submit(() -> {
                Thread.sleep(1000); // simulate blocking
                System.out.println("Done: " + Thread.currentThread());
                return null;
            });
        }

        executor.shutdown();
    }
}
