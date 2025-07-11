package com.tuf.dsa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodingJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**************Even numbers**************************\n");
		findEvenNumber();
		System.out.println("****************numbrs start with 1************************\n");
		findNumberStartWith1();
	}

	private static void findNumberStartWith1() {
		// TODO Auto-generated method stub
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		myList.stream().map(n->n+"").filter(n->n.contains("1")).forEach((n)->{
			System.out.print(" "+n);
		});
		
	}

	private static void findEvenNumber() {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
		List<Integer> evenNumbers= list.stream().filter(n->n%2==0).collect(Collectors.toList());
		evenNumbers.forEach(System.out::println);
	}

}
