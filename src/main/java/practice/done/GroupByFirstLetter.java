package practice.done;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByFirstLetter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hemant", "ajay", "peter", "bob", "adam");

        Map<Character, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println(map);
    }
}
