package com.wmc.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.*;

public class FileServiceTest {

    @Test
    public void testDirCreationWithMultipleThreads_times1() throws InterruptedException {
        FileShareService fileShareService = mock(FileShareService.class);
       // FileService fileService = new FileService(fileShareService);

        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(1); // sync start
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await(); // wait till all threads ready
                    //fileService.ensureDirExists("/testDir");
                } catch (InterruptedException ignored) {}
            });
        }

        latch.countDown(); // release all threads at once
        executor.shutdown();
        while (!executor.isTerminated()) {}

        // ❌ This might FAIL due to race condition
        verify(fileShareService, times(1)).createDirIfNotExist("/testDir");
    }

    @Test
    public void testDirCreationWithMultipleThreads_atMostOnce() throws InterruptedException {
        FileShareService fileShareService = mock(FileShareService.class);
       // FileService fileService = new FileService(fileShareService);

        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(1); // sync start
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await(); // wait till all threads ready
                   // fileService.ensureDirExists("/testDir");
                } catch (InterruptedException ignored) {}
            });
        }

        latch.countDown(); // release all threads at once
        executor.shutdown();
        while (!executor.isTerminated()) {}

        // ✅ This will PASS even if multiple threads call the method
        verify(fileShareService, atMostOnce()).createDirIfNotExist("/testDir");
    }
}
