package com.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * R apply(T t);
 */
public class TestFunction {
    public static void main(String[] args) {

        Function<String,Integer> func1 = s -> s.length();
        System.out.println(func1.apply("hemant"));

        BiFunction<String,String,Integer> biFunc = (s1,s2)->s1.length()+s2.length();
        System.out.println(biFunc.apply("Hemant","kumar"));

        BiFunction<String,String,String> biFunc2 = (s1,s2)->s1.concat(s2);
        System.out.println(biFunc2.apply("Hemant"," kumar"));
    }
}
