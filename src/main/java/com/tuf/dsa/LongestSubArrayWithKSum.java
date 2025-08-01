package com.tuf.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class LongestSubArrayWithKSum {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,1,1,1,1,4,2,3);
        int requiredSum = 6;
        int longestSubArrLeng = brute(nums,requiredSum);
        //int longestSubArrLeng = better(nums,requiredSum);
        //int longestSubArrLeng = optimal(nums,requiredSum);
        System.out.println("Longest sub Array :"+longestSubArrLeng);

    }

    /**
     * solve this with 2 pointer
     * @param nums
     * @param requiredSum
     * @return
     */
    private static int optimal(List<Integer> nums, int requiredSum) {
        int left =0;
        int right =0;
        int maxLen = 0;
        long sum = nums.get(right);
        while (right < nums.size()){

            while (left <= right && sum > requiredSum){
                sum -= nums.get(left);
                left++;
            }

            if(sum == requiredSum){
                maxLen = Math.max(maxLen, right-left+1);
            }

            right++;
            if(right<nums.size()){
                sum += nums.get(right);
            }



        }
           return maxLen;
    }

    private static int better(List<Integer> nums, int requiredSum) {

        long sum =0;
        int maxLen=0;
        Map<Long,Integer> preSumMap = new HashMap<>();

        for (int i=0; i< nums.size(); i++){
            sum += nums.get(i);
            if(sum==requiredSum){
                maxLen = Math.max(maxLen,i+1);
            }

            long rem = sum-requiredSum;

            if(preSumMap.containsKey(rem)){
                int len = i- preSumMap.get(rem);
                maxLen = Math.max(maxLen,len);
            }

            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum,i);
            }

        }
        return maxLen;
    }

    private static int brute(List<Integer> nums, int requiredSum) {

        int length=0;
        for (int i=0; i< nums.size(); i++){
            int sum = 0;
            for (int j=i; j< nums.size(); j++){
                sum += nums.get(j);
                if(sum == requiredSum){
                    length = Math.max(length, j-i+1);
                }
            }
        }
        return length;
    }
}
