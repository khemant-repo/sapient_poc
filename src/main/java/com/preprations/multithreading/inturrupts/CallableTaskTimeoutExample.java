package com.preprations.multithreading.inturrupts;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class CallableTaskTimeoutExample implements Callable<Integer> {


    public AtomicBoolean flag = new AtomicBoolean(true);

    @Override
    public Integer call() throws Exception {

        while (flag.get()){
            System.out.println("executing callable task...");
           Thread.sleep(2000);
            return 1;
        }
        System.out.println("11111111");
       return 0;
    }

    protected void stop() {
        flag.set(false);
        System.out.println("Task stopped...");
    }
}
