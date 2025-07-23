package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

public class FindNumberAppears1Time {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,2,1,5,6,5,6);
        int xor=0;
        for (int i=0; i< nums.size(); i++){
            xor = xor ^ nums.get(i);
        }
        System.out.println(xor + " appears 1 times only..");
    }
}
