package com.preprations.gc;

import java.util.ArrayList;
import java.util.List;

public class MemoryConsumerApp {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> memoryHolder = new ArrayList<>();
        int count = 0;

        while (true) {
            // Allocate 1MB every 100ms
            memoryHolder.add(new byte[1024 * 1024]);
            count++;

            if (count % 50 == 0) {
                System.out.println("Allocated " + count + " MB");
            }

            Thread.sleep(100);
        }
    }
}
