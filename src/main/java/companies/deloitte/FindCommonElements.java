package companies.deloitte;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindCommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int [] arr2 = {4,5,6,7,8,9};

        findCommonElements(arr1,arr2);
    }

    private static void findCommonElements(int[] arr1, int[] arr2) {

        List<Integer> commonElelemts  = Arrays.stream(arr1)
                .filter(arr1Num -> Arrays.stream(arr2).anyMatch(num2 -> num2 == arr1Num))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(commonElelemts);
    }
}
