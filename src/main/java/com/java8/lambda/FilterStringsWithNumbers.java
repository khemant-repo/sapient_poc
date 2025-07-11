package com.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterStringsWithNumbers {
    public static void main(String[] args) {
        String input = "1one,two,three,4four,seven,11eleven,22twelve,3abd,fifteen23,fif50ty";

        String result = Arrays.stream(input.split(","))
                .filter(s -> s.matches(".*\\d.*")) // filters strings containing at least one digit
                .collect(Collectors.joining(","));

        System.out.println("Result: " + result);

        method1();
        method2();
    }

    private static void method2() {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        if (s1 == s2.intern()) {
            System.out.println("s1 and s2 equal");
        } else {
            System.out.println("s1 and s2 not equal");
        }
        if (s1 == s3) {
            System.out.println("s1 and s3 equal");
        } else {
            System.out.println("s1 and s3 not equal");
        }
    }

    public static void method1(){
        var result  = Arrays.asList(34, 56, 23, 87, 41, 22, 15, 74, 39, 54, 75, 28, 95, 48, 31, 93, 86)
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        var sortedList = result.get(true).stream().sorted().collect(Collectors.toList());

        var descList = result.get(false).stream().sorted((n1,n2) -> n2-n1).collect(Collectors.toList());

        System.out.println("*****************sorted list*****************");
        sortedList.forEach(System.out::println);

        System.out.println("*****************Desc sorted list*****************");
        descList.forEach(System.out::println);
    }
}
