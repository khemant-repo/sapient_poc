package com.tuf.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissingNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,4,5);
       findMissingNumber(numbers);
      //  findMissingNumberXor(numbers);
       // findMissingNumberBetter(numbers);
    }

    private static void findMissingNumberBetter(List<Integer> numbers) {
        List<Integer> hashList = new ArrayList<>(Collections.nCopies(numbers.size()+1,0));
        for (int i=0; i< numbers.size()-1; i++){
            hashList.set(numbers.get(i),1);
        }

        for (int i=1; i< hashList.size(); i++){
            if(hashList.get(i)== 0 )
                System.out.println("Missing number is : "+i);
        }


    }

    private static void findMissingNumberXor(List<Integer> numbers) {
        int xor1 = 0;
        int xor2 = 0;
        int n = 4;

        for (int i = 0; i < n; i++) {
            xor2 = xor2 ^ numbers.get(i);
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ n+1;
        int missingNumber = xor1 ^ xor2;
        System.out.println("Missing number: "+missingNumber);

    }

    private static void findMissingNumber(List<Integer> numbers) {
        int n = 5;
        int sum = n* ((n+1)/2);
        System.out.println("sum:" +sum);
        int sum1 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum1:"+sum1);
        int missingNumber = sum-sum1;
        System.out.println("Missing number: "+missingNumber);
    }
}
