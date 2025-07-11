package com.java8.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestPredicate {

    public static void main(String[] args) {

        customPredicate();
        preDefinedPredicate();
        testBiPredicate();
    }

    private static void testBiPredicate() {
        System.out.println("Bipredicate Example");
        BiPredicate<String,Integer> biPredicate = (s,l) -> s.length()==l;
        System.out.println(biPredicate.test("Hello Hemant",12));
    }

    private static void preDefinedPredicate() {
        System.out.println("Predefined predicate Example: ");
        Predicate<Integer> intPredicate = i -> i<5;
        System.out.println(intPredicate.test(4));
        System.out.println(intPredicate.test(-1));
        System.out.println("check: "+check(-1,intPredicate));

        Predicate<String> stringPredicate = s -> s.contains("MR.");
        System.out.println("is string contains MR? "+stringPredicate.test("MR. Hemant is Here"));
        System.out.println("is string contains MR? "+stringPredicate.test("MS. Hemant is Here"));
        System.out.println(check("MS. Hemant is Here",stringPredicate));
    }

    private static void customPredicate() {
        System.out.println("Evaluate Example: custom predicate");
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println(lambda.isNegative(4));
        System.out.println(lambda.isNegative(-1));
    }

    private static <T> boolean  check(T t,Predicate<T> lambda){
        return lambda.test(t);
    }
}
