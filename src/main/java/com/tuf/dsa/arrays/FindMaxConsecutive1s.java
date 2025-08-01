package com.tuf.dsa.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindMaxConsecutive1s {
    public static void main(String[] args) {
        //findMaxConsucutive1();

        List<Integer> nums = Arrays.asList(1,1,0,1,1,1,0,0,1,1,1,1,0,1);

        int max = 0;
        int count = 0;
        for (int i=0; i< nums.size(); i++){
            if(nums.get(i)==1){
                count++;
                max = Math.max(count,max);
            }else {
                count=0;
            }
        }

        System.out.println("maxx conscutive 1's is: "+max);

    }

















    private static void findMaxConsucutive1() {
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
