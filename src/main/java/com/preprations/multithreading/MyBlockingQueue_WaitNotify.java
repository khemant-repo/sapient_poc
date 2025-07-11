package com.preprations.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue_WaitNotify<E> {
    private Queue<E> queue;
    private int max = 16;

    private Object notFUll = new Object();
    private Object notEmpty =  new Object();

    public MyBlockingQueue_WaitNotify(int size){
        queue = new LinkedList<>();
        this.max = size;
    }

    public synchronized  void put(E e) throws InterruptedException {
        if(queue.size() == max){
            notFUll.wait();
        }
        queue.add(e);
        notEmpty.notifyAll();
    }

    public E take () throws InterruptedException {
        while(queue.size() == 0){
            notEmpty.wait();
        }
        E item = queue.remove();
        notFUll.notifyAll();
        return item;
    }
}
