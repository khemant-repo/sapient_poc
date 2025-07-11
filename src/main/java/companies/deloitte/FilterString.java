package companies.deloitte;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterString {

    public static void main(String[] args) {
        String target = "programming";
        String ref = "grm";

       // filterString(target,ref);
        System.out.println("result: "+filterUsingStream(target,ref));
    }

    private static void filterString(String target, String ref) {
        Set<Character> refSet = new HashSet<>();

        for (char c : ref.toCharArray()){
            refSet.add(c);
        }

        StringBuilder result = new StringBuilder();

        for (char c: target.toCharArray()){
            if(!refSet.contains(c))
                result.append(c);
        }
        System.out.println("result: "+result);
    }

    private static String filterUsingStream(String ref, String target){

        Set<Character> refSet = ref.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        return target.chars().mapToObj(c -> (char) c).filter(c-> !refSet.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
