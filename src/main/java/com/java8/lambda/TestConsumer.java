package com.java8.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 * void accept(T t);
 * void accept(T t, U u);
 */
public class TestConsumer {
    public static void main(String[] args) {

        consumer();
        biConsumer();
    }

    private static void biConsumer() {
        Map<String,String> map  = new HashMap<>();
        BiConsumer<String,String> biConsumer = (s1,s2) ->map.put(s1,s2);
        biConsumer.accept("a","b");
        biConsumer.accept("c","d");
        System.out.println(map);
    }

    private static void consumer() {
        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("hello");
        List<String> names = Arrays.asList("hemant","Dheeraj");
        names.forEach(consumer);
    }
}
