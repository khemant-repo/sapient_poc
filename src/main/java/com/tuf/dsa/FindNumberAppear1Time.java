package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

public class FindNumberAppear1Time {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,1,2,3,3,4,4,8,8);
        int xor = 0;
        for (int i = 0; i < array.size(); i++) {
            xor = xor ^ array.get(i);
        }
        System.out.println("number which appears only ones is: "+xor);
    }
}
