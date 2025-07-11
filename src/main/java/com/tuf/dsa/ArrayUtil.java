package com.tuf.dsa;

import java.util.List;

public class ArrayUtil {

    public static void print(int[] nums) {
        // TODO Auto-generated method stub
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
    }

    public static void print(List<Integer> array) {
        for (int i=0 ; i< array.size(); i++){
            System.out.print(array.get(i) +" ");
        }
    }
}
