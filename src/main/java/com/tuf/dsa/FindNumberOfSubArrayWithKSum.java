package com.tuf.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * arr []  = [1,2,3,-3,1,1,1,4,2,-3]
 * k = 3;
 * what is SubArray = All consecutive numbers
 * possible combinations for sum = 3 are
 * 1. {1,2}
 * 2. {1,2,3,-3}
 * 3. {2,3,-3,1}
 * 4.{3}
 * 5. {3,-3,1,1,1}
 * 6. {-3,1,1,1,4,2,-3}
 * 7. {1,1,1}
 * 8. {4,2,-3}
 *
 */
public class FindNumberOfSubArrayWithKSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, -3, 1, 1, 1, 4, 2, -3);
        int k = 3;
        //int noOfSubArray = brute(list, k);
        //int noOfSubArray = better(list, k);
        int noOfSubArray = optimal(list, k);

        display(list);
        System.out.println("Number of Sub Array for given sum K: "+k +"are :"+noOfSubArray);
    }

    private static int optimal(List<Integer> list, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        for (int i=0; i<list.size(); i++){
            prefixSum += list.get(i);
            //calculate x-k
            int remove = prefixSum-k;
            count +=  map.getOrDefault(remove,0);
            // update the count of prefix sum in map

            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);


        }

        return count;
    }

    /**
     *
     * @param list
     * @param expectedSum
     * @return count
     */
    private static int better(List<Integer> list, int expectedSum) {
        int count  = 0;

        int size = list.size();

        for(int i=0; i< size ;i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
               sum +=list.get(j);
                if(sum==expectedSum){
                    count++;
                }
            }

        }

        return count;
    }

    /**
     * 1. calculate all sumArray and  get sum for each subArray
     * 2. if sum == requiredSum , increase count and return at last.
     * 3.
     * @param list
     * @param expectedSum
     * @return
     */
    private static int brute(List<Integer> list, int expectedSum) {
       int count = 0;
        int size = list.size();

        for(int i=0; i< size ;i++) {
            for (int j = i; j < size; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += list.get(k);
                }
                if(sum==expectedSum){
                    count++;
                }
            }
        }
        return count;
    }

    private static void display(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num +", ");
        }
    }
}
