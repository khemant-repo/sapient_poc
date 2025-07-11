package com.preprations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Checkstatic {
 
    public static void check() {
        System.out.println("calling....");
    }
    
    public static void main(String[] args) {
        Checkstatic ch = null;
        //ch.check();
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu core: "+coreCount);
        ExecutorService executor = Executors.newFixedThreadPool(coreCount);

    }
}
