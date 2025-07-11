package com.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * where can we use method ref?
 *
 * If all your lambda expression does is called one method, then that is an opportunity to use a method
 *
 * reference.
 *
 * If a lambda parameter is simply passed to another method, then the redundancy of specifying the variable
 *
 * twice can be removed.
 */
public class MethodReference {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("hemant","ravi","dheeraj");

        names.forEach(name ->System.out.println(name));
        names.forEach(System.out::println);

        boundMR();
    }

    private static void boundMR() {

        String name = "Mr. Hemant Kumar";
        Supplier<String> lowerL =  () -> name.toLowerCase();
        Supplier<String> lowerMR =  name::toLowerCase;

        System.out.println(lowerL.get());
        System.out.println(lowerMR.get());

        Predicate<String> titleL = title -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;
        System.out.println(titleL.test("Mr."));
        System.out.println(titleMR.test("Ms."));
    }
}

