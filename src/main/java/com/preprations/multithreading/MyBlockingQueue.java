package com.preprations.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private Queue<E> queue;
    private int max = 16;
    ReentrantLock lock = new ReentrantLock(true);
    private Condition notFUll = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int size){
        queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() == max){
                System.out.println("Queue is FULL. Producer waiting...");
                notFUll.await();
            }
            queue.add(e);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }


    }

    public E take () throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() == 0){
                System.out.println("Queue is EMPTY. Consumer waiting...");
                notEmpty.await();
            }
            E item = queue.remove();
            System.out.println("Consumed: " + item + ", Queue size: " + queue.size());
            notFUll.signal();
            return item;
        }finally {
            lock.unlock();
        }


    }
}
