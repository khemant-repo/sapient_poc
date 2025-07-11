package com.revise.date02062025;

import java.util.*;
import java.util.stream.Collectors;

public class Revision4June {
    public static void main(String[] args) {
        
        leftRotateBy1Places();
    int x = 'a';
        System.out.println(x);
        //findFirstNonRepeatingCharacter();
        //findDuplicateFromArray();
       // findDuplicateFromArrayByMaintingOrder();
       // removeDuplicateFromArray();
    }

    private static void leftRotateBy1Places() {


    }

    private static void removeDuplicateFromArray() {
        List<Integer> list = Arrays.asList(1,2,4,6,2,4,6,3,33,1,33);
        List<Integer> unique = new ArrayList<>();

        unique = list.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("unique: "+unique);

    }

    private static void findDuplicateFromArray() {
        List<Integer> list = Arrays.asList(1,2,4,6,2,4,6,3,33,1,33);

        Set<Integer> duplicateNumbers = list.stream()
                .filter(n -> Collections.frequency(list, n) > 1)
                .collect(Collectors.toSet());

        System.out.println("duplicateNumbers: "+duplicateNumbers);
    }

    private static void findDuplicateFromArrayByMaintingOrder() {
        List<Integer> list = Arrays.asList(1,2,4,6,2,4,6,3,33,1,33);

        Set<Integer> duplicateNumbers = list.stream()
                .filter(n -> Collections.frequency(list, n) > 1)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("duplicateNumbers with order preserve..: "+duplicateNumbers);
    }

    private static void findFirstNonRepeatingCharacter() {

        String str ="swiss";

        str.chars()
                .mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(c-> c ,LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry-> entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresentOrElse(ch-> System.out.println("first non repeating charater is :"+ch),
                        ()-> System.out.println("No no repeating charater found..."));
    }
}
