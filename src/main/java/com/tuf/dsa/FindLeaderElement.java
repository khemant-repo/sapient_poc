package com.tuf.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Element on right is smaller.
 */
public class FindLeaderElement {
    public static void main(String[] args) {
        //List<Integer> nums = Arrays.asList(10,22,12,3,0,6);
        List<Integer> nums = Arrays.asList(5,4,3,2,1);
        //brute(nums);
        optimal(nums);
    }

    /**
     * 1. we know the last element will always be leader coz no right element exist to compare.
     * 2. we can iterate from last and keep max variable to store max element
     * 3. if n-1 < n-2 , update max and store as leader.
     * @param nums
     */
    private static void optimal(List<Integer> nums) {
        int size  = nums.size();
        List<Integer> leaders = new ArrayList<>(size);

        int max = Integer.MIN_VALUE;

        for (int i= size-1; i>=0; i--){

            if(nums.get(i) > max){
                leaders.add(nums.get(i));
            }
            max = Math.max(max, nums.get(i));
        }
        leaders.sort(Comparator.reverseOrder());
        display(leaders);
    }

    /**
     * check for each element , if no one on right ir greater store it as leader.
     * TL: O(n^2)
     * @param nums
     */
    private static void brute(List<Integer> nums) {
        int n = nums.size();
        List<Integer> leaders = new ArrayList<>(n);
        for (int i=0; i< n; i++){
            boolean leader = true;
            for (int j = i+1; j< n; j++){
                if(nums.get(i) < nums.get(j)){
                    leader = false;
                    break;
                }
            }
            if(leader){
                leaders.add(nums.get(i));
            }
        }

        display(leaders);
    }

    private static void display(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num +", ");
        }
    }
}
