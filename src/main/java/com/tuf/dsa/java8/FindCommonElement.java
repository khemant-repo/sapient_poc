package com.tuf.dsa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindCommonElement {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 4, 5, 6, 7, 8, 1 };

		findCommonElements(arr1, arr2);
	}

	private static void findCommonElements(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		List<Integer> commonNumbers = Arrays.stream(arr1)
				.filter(n1 -> Arrays.stream(arr2)
				.anyMatch(n2 -> n2 == n1))
				.boxed()
				.collect(Collectors.toList());
		// .forEach(System.out::println);
		System.out.println(commonNumbers);
	}
}
