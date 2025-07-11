package demo;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a program to print first non-repeated char "abcabcde" using java-8. OUTPUT-'d'
 */
public class StreamTest {
    public static void main(String[] args) {
        String data = "abcabcde";
        LinkedHashMap<Character, Long> collect = data.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors
                        .counting()));
             Character result =   collect.entrySet()
                                .stream()
                                        .filter(item -> item.getValue() == 1)
                     .map(i -> i.getKey())
                                                .findFirst().orElse(null);
        System.out.println(result);
    }
}
class A1 {
 public void method1(Object o){
     System.out.println("A1 object");
 }
    public void method1(String s){
        System.out.println("A1 String");
    }
}



class A2{
public void method1(Integer i){
    System.out.println("A2: Interger");
}
public void method1(String s){
    System.out.println("A2: String");
}
}
