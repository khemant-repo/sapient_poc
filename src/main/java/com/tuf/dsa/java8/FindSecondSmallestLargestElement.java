package com.tuf.dsa.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class FindSecondSmallestLargestElement {

	public static void main(String[] args) {

		int[] arr = { 5, 3, 4, 1, 2, 8, 5, 6,8,7 };

		findSecondLargestStriver(arr);
		findSecondSmallestStriver(arr);
		//fetchSecondSmallest(arr);

		//System.out.println("*****************************************");
		//fetchSecondLargest(arr);
	}

	private static void findSecondLargestStriver(int[] arr) {
		int largest = arr[0];
		int sLargest = -1;

		for (int i=1; i< arr.length; i++){
			if(arr[i]> largest){
				sLargest = largest;
				largest = arr[i];
			} else if (arr[i] < largest && arr[i]> sLargest) {
				sLargest = arr[i];
			}
		}
		System.out.println("Second largest number is : "+sLargest);
	}


	private static void findSecondSmallestStriver(int[] arr) {
		int smallest = arr[0];
		int sSmallest = Integer.MAX_VALUE;

		for (int i=1; i< arr.length; i++){
			if(arr[i] < smallest){
				sSmallest = smallest;
				smallest = arr[i];
			} else if (arr[i] != smallest && arr[i] <  sSmallest) {
				sSmallest = arr[i];
			}
		}
		System.out.println("sSmallest  number is : "+sSmallest);
	}

	private static void fetchSecondLargest(int[] arr) {
		// TODO Auto-generated method stub
		int secondLargest = Arrays.stream(arr)
				.boxed()
				.distinct()
				.sorted(Collections.reverseOrder())
				.skip(1)
				.findFirst()
				.get();

		System.out.println("second largest from array is : " + secondLargest);
	}

	private static void fetchSecondSmallest(int[] arr) {
		// TODO Auto-generated method stub

		int secondSmallest = Arrays.stream(arr)
				.distinct().
				sorted().
				skip(1).
				findFirst().
				getAsInt();
		System.out.println("second smallest number in array is " + secondSmallest);
	}
}
