package com.tuf.dsa.java8;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestString {

	public static void main(String[] args) {
		String[] stringArr = {"apple","banana","Papaya","grape","watermelon"};
		
		findLongestString(stringArr);
	}

	private static void findLongestString(String[] stringArr) {
		// TODO Auto-generated method stub
		int maxLength = Arrays.stream(stringArr).mapToInt(fruit-> fruit.length()).max().getAsInt();
		String maxWord = Arrays.stream(stringArr).max(Comparator.comparingInt(str-> str.length())).get();
		System.out.println("max lenght fruit is: "+maxLength);
		
		System.out.println("max word: "+maxWord);
	}
}
