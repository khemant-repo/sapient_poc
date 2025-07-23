package com.tuf.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.sort;

/**
 * return "YES" if addition of 2 numbers equal to K else "NO".
 */
public class TwoSumProblem {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2,6,5,8,11);
        int requriedSum = 24;
        String result = twoPointerApproach(nums,requriedSum);
        System.out.println("is two element exist in array which provide sum: "+requriedSum +": "+ result);
    }

    private static String twoPointerApproach(List<Integer> nums, int requriedSum) {

        int left = 0;
        int right = nums.size()-1;

        nums.sort(Comparator.naturalOrder());
        while (left< right){
            int sum = nums.get(left) + nums.get(right);
            if(sum == requriedSum)
                return "YES";
            if(sum < requriedSum){
                left++;
            }else {
                right--;
            }
        }
        return "NO";
    }
}
