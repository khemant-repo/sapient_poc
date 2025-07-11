package com.tuf.dsa.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArrayInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,5,8,12,22}; // expected = {5,4,3,2,1};
		// step1: 5,2,3,4,1
		// ste2 : 5,4,3,2,1
		reverseArray(arr);
	}

	private static void reverseArray(int[] arr) {
		// TODO Auto-generated method stub
		
		IntStream.range(0, arr.length/2).forEach((i)->{
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		});
		Arrays.stream(arr).forEach(System.out::print);
		
	}

}
