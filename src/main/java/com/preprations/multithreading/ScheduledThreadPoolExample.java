package com.preprations.multithreading;

import java.util.concurrent.*;

/**
 * Use when:
 * You need scheduled jobs (e.g., cron-like behavior, cache refreshers)
 */
public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> System.out.println("Running periodic task: " + System.currentTimeMillis());

        scheduler.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS); // starts after 1 sec, runs every 3 sec

    }
}
