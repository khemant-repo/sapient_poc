package com.tuf.dsa;

import java.util.stream.IntStream;

public class FindMaxConsecutive1s {
    public static void main(String[] args) {
        IntStream arr = IntStream.of(1, 1, 0, 1, 1, 1, 0, 1);

        // Convert stream to array since stream is single-use
        int[] nums = arr.toArray();

        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        System.out.println("Maximum consecutive 1s: " + maxCount);
        
    }
    
}
