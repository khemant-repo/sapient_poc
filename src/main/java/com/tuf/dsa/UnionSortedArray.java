package com.tuf.dsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnionSortedArray {
    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> arr2 = Arrays.asList(2, 3, 4, 4, 5, 11, 12);
        List<Integer> unionArray = new ArrayList<>();

        unionArray = union(arr1,arr2);
        //unionArray = unionJava8(arr1,arr2);
        ArrayUtil.print(unionArray);
    }

    /**
     * Steps Performed (Pseudocode)
     * step A: Input Preparation:
     *
     * Initialize two sorted input lists (arr1 and arr2).
     * step B:  Merge and Union Using Java 8 Stream:

     * Step 1: Use Stream.concat() to merge both input lists (arr1 and arr2) into a single stream.
     * Step 2: Use .distinct() to filter out duplicate elements.
     * Step 3: Use .sorted() to sort the merged list.
     * Step 4: Use .collect(Collectors.toList()) to collect the sorted, distinct elements into a List
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static List<Integer> unionJava8(List<Integer> arr1, List<Integer> arr2) {

        return Stream.concat(arr1.stream(),arr2.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }

    /**
     * Pseudocode
     * step1 : Initialize Variables:
     *
     * Create an empty list unionArray to store the union of elements.
     * Set two pointers, index1 and index2, to 0 to traverse arr1 and arr2, respectively.
     *
     * step 2:Merge Arrays Until One List is Exhausted:
     *
     * While both index1 is less than the size of arr1 and index2 is less than the size of arr2:
     * If the current element in arr1 (arr1[index1]) is less than the current element in arr2 (arr2[index2]):
     * If unionArray is empty or its last element is not equal to arr1[index1]:
     * Add arr1[index1] to unionArray (to avoid duplicates).
     * Increment index1.
     * Else (when arr2[index2] is less than or equal to arr1[index1]):
     * If unionArray is empty or its last element is not equal to arr2[index2]:
     * Add arr2[index2] to unionArray (to avoid duplicates).
     * Increment index2.
     *
     * step 3:

     * Add Remaining Elements from arr1:
     * While index1 is less than the size of arr1:
     * If unionArray is empty or its last element is not equal to arr1[index1]:
     * Add arr1[index1] to unionArray.
     * Increment index1.
     * Add Remaining Elements from arr2:
     *
     * While index2 is less than the size of arr2:
     * If unionArray is empty or its last element is not equal to arr2[index2]:
     * Add arr2[index2] to unionArray.
     * Increment index2.
     *
     * step 4: Return the Result:

     * Return unionArray, which now contains the union of both input arrays without duplicates.
     *
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static List<Integer> union(List<Integer> arr1, List<Integer> arr2) {


        List<Integer> unionArray = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while(index1 < arr1.size() && index2 < arr2.size()){
            if(arr1.get(index1) <= arr2.get(index2) ){
                if(unionArray.size() == 0 || !unionArray.contains(arr1.get(index1))){
                    unionArray.add(arr1.get(index1));
                }
                index1++;

            }else{
                if(unionArray.size() == 0 || !unionArray.contains(arr2.get(index2))){
                    unionArray.add(arr2.get(index2));
                } index2++;
            }
        }
        while (index1 < arr1.size()){
            if(!unionArray.contains(arr1.get(index1))){
                unionArray.add(arr1.get(index1));
                index1++;
            }
        }
        while(index2 < arr2.size()){
            if(!unionArray.contains(arr2.get(index2))){
                unionArray.add(arr2.get(index2));
                index2++;
            }
        }

        return unionArray;
    }
}
