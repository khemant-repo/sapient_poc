package com.preprations.multithreading.executers;

public class ToyBuilder extends Thread {
    public void run() {
        System.out.println("Building a toy by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ToyBuilder worker1 = new ToyBuilder(); // create thread
        worker1.start(); // start thread
        System.out.println("Main thread: Managing the factory: Thread Name : "+ Thread.currentThread().getName());
    }
}
