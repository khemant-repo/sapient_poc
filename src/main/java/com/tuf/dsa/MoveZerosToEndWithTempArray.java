package com.tuf.dsa;

import java.util.Arrays;

public class MoveZerosToEndWithTempArray {

    /** use 2 pointer approach to solve this
     * 1. identify 1st zero element index and store it eg. j = arr[i].
     * 2. store next element of j index to second pointer.
     * 3. compare if (j+1) is non-zero swap with j.
     * 4. move j by one place.
     * 5. END.
     * @param arr
     */

    public static void moveZerosToEndOptimal(int[] arr) {
        int j=-1;
        // step1:
        for (int i=0 ; i< arr.length; i++) {
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if (j==-1){
            System.out.println("no zero element found!");
            return;
        }
        //step2:

        for (int i=j+1; i<arr.length ; i++){
            System.out.println("\npass: "+i);
            printArray(arr);
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        //int[] arr = {1,2,2,3,2,3,5,4,5,1};
        System.out.println("\nOriginal Array:");
        printArray(arr);


        //moveZerosToEndBruteForceSolution(arr);
        moveZerosToEndOptimal(arr);
        System.out.println("\nArray after moving zeros to the end:");
        printArray(arr);
    }

    /**
     * 1. put all non-zero elements to temp array
     * 2. push back all non-zero elements from temp to actual array
     * 3. push zero to remaining positions in actual array
     * @param arr
     */
    private static void moveZerosToEndBruteForceSolution(int[] arr) {

        // step1
        int[] temp = Arrays.stream(arr)
                .filter(n-> n!=0)
                .toArray();

        //step2
        for (int i=0;i<temp.length;i++){
            arr[i] = temp[i];
        }

        //step3
        for (int i= temp.length; i< arr.length; i++){
            arr[i] = 0;
        }

    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
