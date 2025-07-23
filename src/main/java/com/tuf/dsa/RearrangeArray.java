package com.tuf.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Array all positive on even index and all negatives on odd index
 */
public class RearrangeArray {
    public static void main(String[] args) {

       // vareity1(); // -ve and +ve are equally divided
        vareity2(); // -ve and +ve are not equally divided, either +ve > -ve or wise versa
    }

    /**
     * 1. in this scenario array might not contain n/2 positive or negative numbers
     * 2. case 1: positive > negative OR
     * 3. case 2: negative > positive.
     * 4. In this case you need to go with brute force approach.
     *  a) keep positive array
     *  b) keep negative array
     *  c) then merge both with odd/even index and at the end add all
     *  the remaining element for either of the array
     */
    private static void vareity2() {
        List<Integer> nums = Arrays.asList(-1,-2,-4,-5,3,6);

        List<Integer> negatives = new ArrayList<>();
        List<Integer> postives = new ArrayList<>();

        for (int i=0; i< nums.size(); i++){
            if(nums.get(i) > 0){
                postives.add(nums.get(i));
            }else {
                negatives.add(nums.get(i));
            }
        }
        if(postives.size() > negatives.size()){
            for (int i=0; i< negatives.size(); i++){
                nums.set(2*i, postives.get(i));
                nums.set(2*i+1, negatives.get(i));
            }
            for (int i = negatives.size()*2; i< postives.size(); i++){
                nums.set(i, postives.get(i));
            }
        }else{
            for (int i=0; i< postives.size(); i++){
                nums.set(2*i, postives.get(i));
                nums.set(2*i+1, negatives.get(i));
            }
            for (int i = postives.size()*2; i< negatives.size(); i++){
                nums.set(i, negatives.get(i));
            }
        }
    display(nums);

    }

    private static void vareity1() {
        List<Integer> nums = Arrays.asList(3,1,-2,-5,2,-4);
     //   bruteVareity1(nums);
        optimalVareity1(nums);
    }

    private static void optimalVareity1(List<Integer> nums) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(nums.size(),0));

        int posIndex = 0;
        int negIndex = 1;
        for (int i=0; i< nums.size(); i++){
            if(nums.get(i) > 0){
                results.set(posIndex, nums.get(i));
                posIndex +=2;
            }else {
                results.set(negIndex, nums.get(i));
                negIndex += 2;
            }
        }

        display(results);
    }

    private static void display(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num +", ");
        }
    }

    private static void bruteVareity1(List<Integer> nums) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> postives = new ArrayList<>();

        for (int i=0; i< nums.size(); i++){
            if(nums.get(i) > 0){
                postives.add(nums.get(i));
            }else {
                negatives.add(nums.get(i));
            }
        }


        for (int i=0; i< postives.size(); i++){
            nums.set(2*i, postives.get(i));
            nums.set(2*i+1, negatives.get(i));
        }
        display(nums);
    }
}
