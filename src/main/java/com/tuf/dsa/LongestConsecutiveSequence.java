package com.tuf.dsa;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Consecutive numbers are numbers that follow each other in order, without any gaps.
 *  Examples:
 * 1, 2, 3, 4, 5 → consecutive numbers
 * 10, 11, 12 → consecutive
 * -3, -2, -1, 0, 1 → consecutive
 *
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(100,102,100,101,101,5,4,3,2,3,2,1,1,1,2);
      //  int lcsLength = brute(arr);
        //int lcsLength = better(arr);
        int lcsLength = optimal(arr);

        System.out.println("Longest consecutive sequence length is : "+lcsLength);
    }

    /**
     * 1. use set to contain unique elements.
     * 2. for each element check if element-1 exist, if yes, no need to check further
     * 3. if element-1 does not exist in array, use it as starting element
     * 4. check if element+1 exist and increase counter.
     * 5. maintain max(longest)
     * 6. return longest
     * @param arr
     * @return
     */
    private static int optimal(List<Integer> arr) {

        if(arr.size() == 0)
            return 0;
        int longest = 1;
        Set<Integer> elements = arr.stream().collect(Collectors.toSet());
        for(Integer element : elements){
            int count = 1;
            if(!elements.contains(element-1)){
                int startEle = element;
                while (elements.contains(startEle+1)){
                    count++;
                    startEle++;
                }
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    /**
     * 1. sort arr
     * 2. maintain last_smallest, count and longest
     * 3. iterate over entire array
     * 4. for each element check if i-1 == last_smallest then increase counter and udpate last_smallest
     * 5. if i-1 == last_smallest , ignore
     * 6. if i-1 != last_smallest , reset lastSmallest = i, counter = 1
     * @param arr
     * @return
     */
    private static int better(List<Integer> arr) {

        int lastSmallest = Integer.MIN_VALUE;
        int count = 1;
        int longest =0;
        int size = arr.size();
        arr.sort(Comparator.naturalOrder());
        for (int i=0; i< size; i++){
            if(arr.get(i)-1 == lastSmallest){
                lastSmallest = arr.get(i);
                count++;
            } else if (arr.get(i) != lastSmallest) {
                lastSmallest = arr.get(i);
                count = 1;
            }
            longest = Math.max(longest,count);
        }

        return longest;
    }

    /**
     * 1. for each element iterate in entire array if n+1 present increase count
     * 2. after each run cacluate max(longest).
     * 3. return longest
     * time complext : O(n^2)
     * @param arr
     * @return
     */
    private static int brute(List<Integer> arr) {
        return 0;
    }
}
