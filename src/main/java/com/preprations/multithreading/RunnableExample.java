package com.preprations.multithreading;

public class RunnableExample {
    public static void main(String[] args) {
      Runnable task = new Runnable() {
          @Override
          public void run() {
              System.out.println("got get vegitables..");
          }
      };
        new Thread(()-> System.out.println("got get vegitables..")).start(); // lambda
        new Thread(task).start();
    }
}
