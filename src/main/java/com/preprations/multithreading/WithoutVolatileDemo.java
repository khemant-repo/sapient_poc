package com.preprations.multithreading;

public class WithoutVolatileDemo {
    static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread-1 started");
            while (flag) {
                // Busy wait
                System.out.println("while executing...");
            }
            System.out.println("Thread-1 detected flag = false and stopped.");
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Give thread1 some time to run
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            System.out.println("Thread-2 updated flag to false.");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
