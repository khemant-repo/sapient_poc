package com.tuf.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SortArray3Pointer {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0,1,1,0,1,2,1,2,0,0,0);

       // better(nums);
        optimalSolution(nums);
    }

    /**
     * The Dutch National Flag Algorithm is a famous algorithm designed
     * by Edsger Dijkstra to solve problems involving sorting an array of three
     * distinct values.
     * The name comes from the three colors of the Dutch flag: red, white, and blue.
     *
     * This Algo is used to sort an array that contains only three distinct elements
     * (like 0, 1, and 2) in linear time and with constant space.
     */
    private static void optimalSolution(List<Integer> nums) {

        int low = 0;
        int mid = 0;
        int high = nums.size()-1;

        int count =0;
        while (mid<=high){
            printArray(nums,count++);
            if (nums.get(mid) == 0){
                int temp = nums.get(low);
                nums.set(low,nums.get(mid));
                nums.set(mid,temp);
                low++;
                mid++;
            }else if(nums.get(mid) == 1){
                mid++;
            }else{
                int temp = nums.get(mid);
                nums.set(mid,nums.get(high));
                nums.set(high,temp);
                high--;
            }
        }
        printArray(nums,count);
    }

    private static void printArray(List<Integer> nums,int count) {
        System.out.println("iteration:" +count);
        for (int i = 0; i< nums.size(); i++){
            System.out.print( nums.get(i)+"  ");
        }
        System.out.println();
    }

    private static void swap(int start, int end, List<Integer> nums) {

        nums.set(start,nums.get(end));
        nums.set(end,nums.get(start));
    }

    private static void better(List<Integer> nums) {

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        List<Integer> result = new ArrayList<>(Collections.nCopies(nums.size(),0));
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 0) {
                zeroCount++;
            } else if (nums.get(i) == 1) {
                oneCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            result.set(i, 0); //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        }
        for (int i = zeroCount; i < zeroCount+oneCount; i++) {
            result.set(i, 1);
        }
        for (int i = zeroCount+oneCount; i < nums.size(); i++) {
            result.set(i, 2);
        }
     //   printArray(result);
    }

}
