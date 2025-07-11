package companies.deloitte;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestString {
    public static void main(String[] args) {

        String[] strings = {"apple","banana","apricot","lemon","avacado","hemantkumar"};

        findLength(strings);
    }

    private static void findLength(String[] strings) {
        int maxLenght = Arrays.stream(strings)
                .mapToInt(fruit-> fruit.length()).max().getAsInt();
    String word = Arrays.stream(strings).max(Comparator.comparing(str-> str.length())).get();
        System.out.println("word"+word);
        System.out.println("maxLenght"+maxLenght);
    }
}
