package com.preprations.multithreading.executers;

public class CPUTask implements Runnable{
    @Override
    public void run() {
        System.out.println("CPU Intensive task...");
    }
}
