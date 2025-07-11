package com.preprations.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Initial Result";
        }).thenApply(result -> result +" next step")
                .thenApply(result -> result +" final result ");

        System.out.println("other work");

        String finalResult = future.get();

        System.out.println("result" + finalResult);
    }
}
