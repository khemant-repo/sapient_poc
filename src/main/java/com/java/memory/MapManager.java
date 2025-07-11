package com.java.memory;

import java.util.HashMap;

public class MapManager {
    private static HashMap<Object, Object> myMap = new HashMap<>();


    public void grow() {
        try{
            long counter = 0;
            while (true){
                myMap.put("key" +counter, "Large Stringggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                        "ggg "+counter);

                if(++counter %1000 == 0){
                    System.out.println("inserted thousand records to map..");
                    System.out.println("Map size: "+myMap.size());
                    //currentMemory();

                }
            }
        }catch (Exception e){
            System.out.println("Map size: "+myMap.size());
            e.printStackTrace();
        }


    }

    private static void currentMemory() {
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();         // Max heap memory (Xmx)
        long totalMemory = runtime.totalMemory();     // Total memory currently in use
        long freeMemory = runtime.freeMemory();       // Free memory within the allocated heap

        System.out.println("Max Memory (heap -Xmx): " + (maxMemory / (1024 * 1024)) + " MB");
        System.out.println("Total Memory: " + (totalMemory / (1024 * 1024)) + " MB");
        System.out.println("Free Memory: " + (freeMemory / (1024 * 1024)) + " MB");
    }
}
