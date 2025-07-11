package com.revise.date02062025;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Revision06june2025 {
    public static void main(String[] args) {
        // removeDuplicateFromArray();
        // getUniqueNumbers();
        // findFirstnonRepeatingCharUsingStreams();
        // findFirstnonRepeatingCharWithoutUsingStreams();
    }

    private static void getUniqueNumbers() {
        List<Integer> numbers = Arrays.asList(1, 44, 1, 33, 4, 5, 17, 16, 5);

        Set<Integer> uniqueNumber = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !uniqueNumber.add(n)).collect(Collectors.toSet());

        System.out.println("uniqueNumber: " + uniqueNumber);
        System.out.println("duplicates : " + duplicates);
    }

    private static void removeDuplicateFromArray() {

        List<Integer> numbers = Arrays.asList(1, 44, 1, 33, 4, 5, 17, 16, 5);

        Set<Integer> collect = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) > 1)
                .collect(Collectors.toSet());

        System.out.println("collect: " + collect);
    }

    private static void findFirstnonRepeatingCharWithoutUsingStreams() {
        String str = "swiss";

        Map<Character, Long> charCount = new LinkedHashMap<>();

        for (Character ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0L) + 1);
        }
        for (Map.Entry<Character, Long> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("first non repeating charater.." + entry.getKey());
                break;
            }

        }


    }

    private static void findFirstnonRepeatingCharUsingStreams() {
        String str = "swiss";

        Optional<Character> firstNonRepeatingChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        firstNonRepeatingChar.ifPresentOrElse(
                ch -> System.out.println("first non repeating character is: " + ch),
                () -> System.out.println("no non repeating char found...")
        );
    }

    private static void removeDuplicate() {
        List<String> fruits = Arrays.asList("Banana", "apple", "mango", "banana", "lichi", "apple");
        Set<String> uniqueFruit = new LinkedHashSet<String>(fruits);

        System.out.println(uniqueFruit);
    }
}
