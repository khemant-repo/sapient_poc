package demo;

import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hemant","Dhruv");
        list.stream().filter(name-> name.startsWith("h"))
        .forEach(name-> System.out.println(name));
    }
}
