package com.tuf.dsa.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindDuplicateElements {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,5,6,2,4,1,6,9,7,2);
		//getDuplicateWithSet(numbers);
		
		//getDuplicateWithGroupingBy(numbers);
		getDuplicatebyFrequency(numbers);
		//removeDuplicateElement();
	}

	private static void removeDuplicateElement() {
		 int a[] = { 1, 3, 3, 4, 2, 1, 5, 6, 7, 7, 8, 10 };
		   // Arrays.sort(a);
		    int j = 0;
		    
		    for (int i = 0; i < a.length - 1; i++) {
		        if (a[i] != a[i + 1]) {
		            a[j] = a[i];
		            j++;
		        }
		    }
		    a[j] = a[a.length - 1];
		    for (int i = 0; i <= j; i++) {
		        System.out.print(a[i]+" ");
		    }
	}

	private static void getDuplicateWithSet(List<Integer> numbers) {
		System.out.println("Duplicate by set..........");
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		numbers.stream().filter(n -> !uniqueNumbers.add(n)).forEach(System.out::print);
		Set<Integer> duplicateNumbers = numbers.stream().filter(n -> !uniqueNumbers.add(n)).collect(Collectors.toSet());
		
		System.out.println("duplicateNumbers: "+duplicateNumbers);
		System.out.println("uniqueNumbers: "+uniqueNumbers);
	}

	private static void getDuplicatebyFrequency(List<Integer> numbers) {
		// TODO Auto-generated method stub
		System.out.println("\nDuplicate by frequency.........");
		Set<Integer> duplicateNumbers = numbers.stream()
				.filter(n-> Collections.frequency(numbers,n)> 1)
				.collect(Collectors.toSet());//forEach(System.out::print);
		System.out.println(duplicateNumbers);

	}

	private static void getDuplicateWithGroupingBy(List<Integer> numbers) {
		// TODO Auto-generated method stub
		System.out.println("\nDuplicate by group by..........");
		Stream<String> stringStream = Stream.of("hemant","muskan","tom","hemant","john","tom");
		Map<String,Long> map = stringStream.collect(Collectors.groupingBy(str->str, Collectors.counting()));
		
		System.out.println(map);
		
		map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry->entry.getKey()).forEach(System.out::print);
		
	}
}
