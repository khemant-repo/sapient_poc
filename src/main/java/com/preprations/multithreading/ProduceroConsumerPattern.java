package com.preprations.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceroConsumerPattern {

    public static void main(String[] args) {
       // withInbuildBLockingQueue();
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);

        Runnable producer = () -> {
          while (true){
              try {
                  queue.put(1);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
          while(true){
              try {
                  int item =  queue.take();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
    }

    private static void withInbuildBLockingQueue() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        final Runnable producer = () -> {
            while(true){
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException occured..");
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
            while(true){
                try {
                    int item = queue.take();
                    System.out.println("item consumed: "+item);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException occured..");
                    throw new RuntimeException(e);
                }
            }
        };
          new Thread(consumer).start();
        new Thread(consumer).start();
    }


}
