package com.tuf.dsa;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class MaxSubarraySum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(-2,-3,4,-1,-2,1,5,-3);
        //int maxSum = optimal(arr);
        int maxSum = optimalAndPrintSubaArrayIndex(arr);
        System.out.println("max sum array sum is: "+maxSum);
    }

    private static int optimalAndPrintSubaArrayIndex(List<Integer> arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start=-1;
        int startIndex = -1;
        int endIndex = -1;
        for (int i=0; i< arr.size(); i++){

            if(sum==0){
                start = i;
            }
            sum += arr.get(i);

            if(sum > maxSum)
            {
                maxSum = sum;
                startIndex = start;
                endIndex = i;
            }
            if(sum< 0){
                sum =0;
            }

        }
        System.out.println("SubArray with max sum: ");
        arr.subList(startIndex,endIndex+1).stream()
                .forEach(System.out::println);
        return maxSum < 0 ? 0: maxSum;
    }

    private static int optimal(List<Integer> arr) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i< arr.size(); i++){
            sum += arr.get(i);

            if(sum > maxSum)
            {
                maxSum = sum;
            }
            if(sum< 0){
                sum =0;
            }

        }
        return maxSum < 0 ? 0: maxSum;
    }

}
