package com.preprations.multithreading;

import java.util.concurrent.Callable;

public class MyTask implements Callable<String> {
    private final int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);  // simulate work
        return "Task " + id + " completed by " + Thread.currentThread().getName();
    }
}
