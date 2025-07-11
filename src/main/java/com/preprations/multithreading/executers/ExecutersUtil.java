package com.preprations.multithreading.executers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutersUtil {

    protected static void executeSimpleTask(){
        for(int i=0 ; i<10; i++){
           new Thread(new SimpleTask()).start();
        }
    }

    protected static void executeCallableTask(){
       ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0 ; i<10; i++){
            Future<Integer> future = executorService.submit(new CallableTask());
            System.out.println("other tasks");

            try {
                Integer result = future.get();
                System.out.println("Callable result: "+result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
        executorService.shutdown();
    }


    protected static void cpuIntensiveTask() {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Available core.."+core);
        ExecutorService executorService = Executors.newFixedThreadPool(core);
        for (int i=0 ; i<10;i++){
            executorService.submit(new CPUTask());
        }
        executorService.shutdown();
        System.out.println("is Shutdown initiated..."+executorService.isShutdown());

        //will throw RejectedExecutionException because we already initiated shutdown
        // for executer service.
        // Already submitted task will be executed before shutting it down but no new tasks are accepted.
        //executorService.submit(new CPUTask());
    }

    protected static void ioIntensiveTask() {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Available core.."+core);
        ExecutorService executorService = Executors.newFixedThreadPool(2 * core);
        for (int i=0 ; i<100;i++){
            executorService.submit(new IOTask());
        }
        executorService.shutdown();
    }
}
