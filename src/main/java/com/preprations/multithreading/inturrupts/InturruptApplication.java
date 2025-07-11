package com.preprations.multithreading.inturrupts;

import java.util.concurrent.*;

/**
 * Example to stop thread execution with timeout.
 */
public class InturruptApplication {
    public static void main(String[] args) {
        //timeout_1();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CallableTaskTimeoutExample task = new CallableTaskTimeoutExample();
        Future<Integer> future = executorService.submit(task);
        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.out.println("timeout exception occured..."+e.getMessage());
            task.stop();
            try {
                Integer result = future.get();
                System.out.println("result after stopp.."+result);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }


    }

    private static void timeout_1() {
        MyTaskTimout myTask = new MyTaskTimout();
        Thread t1 = new Thread(myTask);

        t1.start();

        try {
            Thread.sleep(200);// after 200ms call stop()
            myTask.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
