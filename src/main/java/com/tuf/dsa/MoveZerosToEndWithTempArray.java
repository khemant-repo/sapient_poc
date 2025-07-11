package com.tuf.dsa;

public class MoveZerosToEndWithTempArray {

    public static void moveZerosToEnd(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;

        // Collect all non-zero elements into the temp array
        for (int num : arr) {
            if (num != 0) {
                temp[index++] = num;
            }
        }

        // Copy non-zero elements back to the original array
        for (int i = 0; i < index; i++) {
            arr[i] = temp[i];
        }

        // Fill the rest of the array with zeros
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        moveZerosToEnd(arr);

        System.out.println("\nArray after moving zeros to the end:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
