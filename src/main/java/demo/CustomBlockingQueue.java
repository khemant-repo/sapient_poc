package demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<E> {

    private final Queue<E> queue;
    private final int maxSize;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public CustomBlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.maxSize = size;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                System.out.println("Queue is FULL. Producer waiting...");
                notFull.await();
            }
            queue.add(e);
            System.out.println("Produced: " + e + ", Queue size: " + queue.size());
            notEmpty.signal(); // signal one waiting consumer
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue is EMPTY. Consumer waiting...");
                notEmpty.await();
            }
            E item = queue.remove();
            System.out.println("Consumed: " + item + ", Queue size: " + queue.size());
            notFull.signal(); // signal one waiting producer
            return item;
        } finally {
            lock.unlock();
        }
    }
}
