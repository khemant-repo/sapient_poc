package com.preprations.multithreading;

public class Printer {

    // Instance-level synchronized method (locks on 'this')
    public synchronized void instancePrint(String message) {
        System.out.println(Thread.currentThread().getName() + " entered instancePrint: " + message);
        try {
            Thread.sleep(1000); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exiting instancePrint: " + message);
    }

    // Class-level synchronized method (locks on Printer.class)
    public static synchronized void classPrint(String message) {
        System.out.println(Thread.currentThread().getName() + " entered classPrint: " + message);
        try {
            Thread.sleep(1000); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exiting classPrint: " + message);
    }
}
