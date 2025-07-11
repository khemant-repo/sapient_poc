package com.preprations.multithreading.executers;

public class IOTask implements Runnable{

    @Override
    public void run() {

        System.out.println("IO intensive task....");
    }
}
