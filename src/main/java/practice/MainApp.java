package practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Problem Statement:
 * You have a list of string representing people's name. Few names are duplicate. Your task is to:
 *
 * 1. Group the names by their frequency.
 * 2. Sort the group in descending order of frequency.
 * 3. Sort the names alphabetically, when 2 Names have same frequency.
 * 4. Return the sorted result as a list of strings, with each string formatted as: name (count).
 *
 * List<String> names = Arrays.asList("Alice", "Bob", "David", "Alice",
 * "Alice", "David", "Bob", "Charlie", "David", "Charlie", "Bob", "David");
 *
 * Expected Output: [
 *   "David (4)",
 *   "Alice (3)",
 *   "Bob (3)",
 *   "Charlie (2)"
 * ]
 */
public class MainApp {

    public static void main(String[] args) {

        String str = "ththththth";
        //output: hhhhhttttt
        System.out.println((int)'h');
        System.out.println((int)'k');
        System.out.println((char) 104);
        System.out.println((char) 106);
       var result = str.chars()
                .mapToObj(c-> (char)c)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("result sorted: "+result);

        //extracted1();

        //extracted();

    }

    private static void extracted1() {
        // na, ha, ra
        //String str = na,ha,ra;
       /* String name = "Hemanth";
        Stream.of(name.toCharArray())
                .collect(Collections.frequency(name, ch-> ch), Collectors.joining(","),LinkedHashMap::new);*/
    }

    private static void extracted() {
        List<String> names = Arrays.asList("Alice", "Bob", "David", "Alice", "Alice", "David", "Bob", "Charlie", "David", "Charlie", "Bob", "David");

        Map<String,List<String>> result = names.stream()
                .collect(Collectors.groupingBy(s-> s));


        System.out.println(result);
    }


}
