package com.tuf.dsa.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestElementInArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 2, 5, 8, 1, 0);
        System.out.println("List elements ..");
        ArrayUtil.print(list);
        //int maxElement = brute(list);
        int maxElement = better(list);
        System.out.println("Max element from list is: ..."+maxElement);

    }

    private static int better(List<Integer> list) {
        int max = list.get(0);
        for (int i=1; i< list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }

    private static int brute(List<Integer> list) {
      list.sort(Comparator.naturalOrder());

        return list.get(list.size()-1);
    }
}
