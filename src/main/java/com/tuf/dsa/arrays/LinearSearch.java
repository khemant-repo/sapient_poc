package com.tuf.dsa.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * return first occurrence of given number.
 */
public class LinearSearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 3, 7, 1);
        int num = 7;
        int index = findFirstOccurrenceOfGivenNumber(list,num);
        System.out.println("given index of "+num +" is "+index);
    }

    private static int findFirstOccurrenceOfGivenNumber(List<Integer> list, int num) {
        for (int i=0; i< list.size(); i++){
            if(list.get(i)==num){
                return i;
            }
        }
        return -1;
    }
}
