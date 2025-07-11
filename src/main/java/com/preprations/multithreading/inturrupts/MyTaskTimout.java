package com.preprations.multithreading.inturrupts;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyTaskTimout implements Runnable{

    //public volatile boolean flag = true;
    public AtomicBoolean flag = new AtomicBoolean(true);
    @Override
    public void run() {
        while(flag.get()){
            System.out.println("task is running...");
        }
        stop();
    }

    protected void stop() {
        flag.set(false);
        System.out.println("Task stopped...");
    }
}
