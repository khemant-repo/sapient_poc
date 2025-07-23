package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

public class FindMajorityElement {
    public static void main(String[] args) {
     //List<Integer> arr = Arrays.asList(7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5);
        List<Integer> arr = Arrays.asList(6,5,5);
       // int majorityElement =  brute(arr);
       // int majorityElement =  better(arr);
        int majorityElement =  optimal(arr);
        String result = majorityElement == -1 ? "Not found" : "Found: "+majorityElement ;
        System.out.println("Majority Element in given array "+result);
    }

    /**
     * 1. moore's majority element algorithm
     * 2. take first element from array , keep counter=1
     * 3. if counter becomes = 0, update element with latest element and repeat.
     * 4. if currentElement == element, counter++ else counter--;
     * 5. loop in array , check if element is > n/2.
     * 6.
     *
     *
     * @return
     */
    private static int optimal(List<Integer> arr) {
        int counter = 0;
        int element = arr.get(0);

        for (int i=0;i < arr.size(); i++){
            if(counter == 0){
                counter = 1;
                element = arr.get(i);
            }
          else  if(element==arr.get(i)){
                counter++;
            }else {
                counter--;
            }
        }
        int count = 0;
        for (int i=0; i< arr.size(); i++){
            if(arr.get(i)==element){
                count++;
            }
        }
        if(count > arr.size()/2){
            return element;
        }
        return -1;
    }

    /**
     * 1. Hash count of each element in map.
     * 2. iterate map and check if value > n/2 , return that element else -1;
     * @return
     */
    private static int better(List<Integer> arr) {
        return -1;
    }

    /**
     * 1. loop each element in entire array and count.
     * 2. if count ? n/2 , return element else -1;
     * @param arr
     * @return
     */
    private static int brute(List<Integer> arr) {
        return -1;
    }

}
