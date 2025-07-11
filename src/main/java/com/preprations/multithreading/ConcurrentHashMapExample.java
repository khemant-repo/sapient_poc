package com.preprations.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
       // exmpale1();
        //exmapleNullKeyValue();
        //putIfAbsent_multiple();
      //  concurrentModificationEx();
        concurrentModificationEx_resolved();
    }

    private static void concurrentModificationEx_resolved() {
        Map<String,String> list = new ConcurrentHashMap<String,String>();
        list.put("A","A");
        list.put("B","B");
        for (String item : list.values()) {
            list.put("C","C");// Fail-fast: throws ConcurrentModificationException
            System.out.println(item);
        }
    }

    private static void concurrentModificationEx() {
        Map<String,String> list = new HashMap<String,String>();
        list.put("A","A");
        list.put("B","B");
        for (String item : list.values()) {
            list.put("C","C");// Fail-fast: throws ConcurrentModificationException
            System.out.println(item);
        }
    }

    private static void putIfAbsent_multiple() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("key", "value1");  // Successfully inserts "key" => "value1"
        map.putIfAbsent("key", "value2");  // Does not modify the map, returns "value1"
        System.out.println(map.get("key"));
    }

    private static void exmapleNullKeyValue() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put(null, "value");  // Throws NullPointerException
        map.put("key", null);     // Throws NullPointerException

    }

    private static void exmpale1() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        // Adding key-value pairs
        map.put("A", "Apple");
        map.put("B", "Banana");

        // Thread 1: Adding a new key-value pair
        Runnable task1 = () -> map.put("C", "Cherry");

        // Thread 2: Reading a value
        Runnable task2 = () -> System.out.println("Key C: " + map.get("C"));

        // Start threads
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
