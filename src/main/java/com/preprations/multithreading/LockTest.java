package com.preprations.multithreading;

public class LockTest {
    public static void main(String[] args) {
        Printer p1 = new Printer();
        Printer p2 = new Printer();

        // 1️⃣ Instance-level locking demo (different instances — should run in parallel)
        Thread t1 = new Thread(() -> p1.instancePrint("From t1"));
        Thread t2 = new Thread(() -> p2.instancePrint("From t2")); // different object — no lock contention

        // 2️⃣ Class-level locking demo (static method — both threads will block each other)
        Thread t3 = new Thread(() -> Printer.classPrint("From t3"));
        Thread t4 = new Thread(() -> Printer.classPrint("From t4"));

        // Run instance-level lock test
        System.out.println("Starting instance-level locking demo...");
        t1.start();
        t2.start();

        // Wait for the above to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Run class-level lock test
        System.out.println("\nStarting class-level locking demo...");
        t3.start();
        t4.start();
    }
}
