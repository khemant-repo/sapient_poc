package com.tuf.dsa.arrays;

import java.util.Arrays;
import java.util.List;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        //List<Integer> list = Arrays.asList(1, 2, 6, 4, 5, 3);
       // boolean isSorted = brute(list);
        boolean isSorted = optimal(list);

        System.out.println("Is Given Array is Sorted? ");
        ArrayUtil.print(list);

        System.out.println("isSorted: "+isSorted);
    }

    /**
     * 1. check is each element is greater than it's previous element.
     * @param list
     * @return
     */
    private static boolean optimal(List<Integer> list) {
        boolean isSorted = true;

        for (int i=1; i< list.size(); i++){
            if(list.get(i) < list.get(i-1)){
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    /**
     * 1. start from element 0 and check in entire array if all element greater than that
     * return array is sorted true.
     * @param list
     * @return
     */
    private static boolean brute(List<Integer> list) {
        boolean isSorted = true;
        for (int i= 0; i< list.size(); i++){
            for (int j=i+1; j< list.size();j++){
                if(list.get(j)  < list.get(i)){
                    isSorted = false;
                    break;
                }
            }
        }
        return isSorted;

    }
}
