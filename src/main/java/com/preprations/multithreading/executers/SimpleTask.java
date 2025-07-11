package com.preprations.multithreading.executers;

public class SimpleTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Simple task running by Thread: " +Thread.currentThread().getName());
    }
}
