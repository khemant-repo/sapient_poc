package com.tuf.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeftRotateArrayByKPlaces {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int k =3;
        System.out.println("Original Array..");

        ArrayUtil.print(list);
        //List<Integer> rotatedList = brute(list,k);
        List<Integer> rotatedList = optimal(list,k);

        System.out.println("After Rotating List by "+k +" places.");
        ArrayUtil.print(rotatedList);
    }

    private static List<Integer> optimal(List<Integer> list, int k) {
        reverseList(list,0,k);
        System.out.println("After first reversal");
        ArrayUtil.print(list);

        reverseList(list,k,list.size());
        System.out.println("After second reversal");
        ArrayUtil.print(list);

        reverseList(list,0,list.size());
        System.out.println("After final reversal");
        ArrayUtil.print(list);

        return list;
    }

    private static void reverseList(List<Integer> list, int i, int k) {
        int left = i;
        int right = k-1;

        while (left < right) {
            // Swap elements at left and right
            Collections.swap(list, left, right);
            left++;
            right--;
        }
    }

    private static List<Integer> brute(List<Integer> list, int k) {
        List<Integer> tempList = new ArrayList<>();
        k = k % list.size(); // to calcualte number of shift required, you will always come
        // back to same list if n iterations required so no point of shifting if k > list.size.
        for (int i=0;i< k; i++){
            tempList.add(list.get(i));
        }
        for(int i=k;i<list.size() ;i++){
            list.set(i-k, list.get(i));
        }

        for(int i= list.size()-k; i< list.size(); i++){
            list.set(i, tempList.get( i-(list.size()-k)));
        }
        return list;
    }
}
