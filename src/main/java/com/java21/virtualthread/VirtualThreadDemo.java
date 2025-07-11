package com.java21.virtualthread;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Running in: " + Thread.currentThread());
        };

        Thread t = Thread.ofVirtual().start(task);
    }
}
