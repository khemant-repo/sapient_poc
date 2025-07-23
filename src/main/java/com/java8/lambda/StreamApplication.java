package com.java8.lambda;

import com.java8.dto.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApplication {
    public static void main(String[] args) {

        //factorial();
        //currentMemory();
        //streamPractice();
        // internal();
        sdGLobal();

    }

    private static void internal() {
        //test1();
        //String result  = k1=v1,v2,v3,v4.... - k2= v1,v2,v3,v4..... - same pattern
        Map<String, List<String>> map = new HashMap<>();
        map.put("k1", Arrays.asList("v1", "v2", "v3"));
        map.put("k2", Arrays.asList("v4", "v5", "v6"));
        map.put("k3", Arrays.asList("v7", "v8", "v9"));
       /* String result = map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + String.join(",", entry.getValue()))
                .collect(Collectors.joining(" - "));

        System.out.println(result);*/
        String collect = map.entrySet()
                .stream()
                .map(entry -> {
                    return entry.getKey() + " =" + entry.getValue().stream().collect(Collectors.joining(" ,"));
                }).collect(Collectors.joining(" - "));
        System.out.println(collect);

        sdGLobal();
    }

    /**
     * grade > 5 and grade < 9.
     */
    private static void sdGLobal() {
        List<Student> stuList = Arrays.asList(
                new Student("loom", 7, 2, 4),
                new Student("Amay", 7, 2, 4),
                new Student("Vijay", 7, 2, 4),
                new Student("Ajay", 6, 2, 4),
                new Student("Rahul", 1, 2, 4),
                new Student("Rehan", 10, 2, 4),
                new Student("Alan", 6, 2, 4),
                new Student("Robin", 6, 2, 4),
                new Student("Kevin", 12, 2, 4));

        Predicate<Student> pred = (student -> student.getGrade() > 5 && student.getGrade() < 9);
        var result = stuList
                .stream().filter(student -> student.getGrade() > 5 && student.getGrade() < 9)
                .collect(Collectors.toMap(
                        student-> student.getGrade(),
                        student-> student.getName(),
                        (s1,s2)-> s1+" ,"+ s2


                ));

        System.out.println(result);
    }

    private static void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Hemant", 6);
        var map1 = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        System.out.println(map1);
    }

    private static void currentMemory() {
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();         // Max heap memory (Xmx)
        long totalMemory = runtime.totalMemory();     // Total memory currently in use
        long freeMemory = runtime.freeMemory();       // Free memory within the allocated heap

        System.out.println("Max Memory (heap -Xmx): " + (maxMemory / (1024 * 1024)) + " MB");
        System.out.println("Total Memory: " + (totalMemory / (1024 * 1024)) + " MB");
        System.out.println("Free Memory: " + (freeMemory / (1024 * 1024)) + " MB");
    }

    private static void factorial() {
        int n = 4;
        System.out.println("Factorial of :" + n + " is " + StreamUtil.findFactorial(n));
    }

    private static void streamPractice() {
//        StreamUtil.exploreCreateStream();
//        StreamUtil.practiceFilter();
        //  StreamUtil.practiceTerminalOperations();
        //    StreamUtil.practiceIntermediateOPerations();
        //StreamUtil.practicePrimitiveStream();
        //StreamUtil.practiceOptional();
        StreamUtil.practiceParallelStream();
        StreamUtil.toMapExample();
//        StreamUtil.reverseEachWord();
        //  StreamUtil.practiceCollect();
        //  StreamUtil.practiceGroupingBy();
    }
}
