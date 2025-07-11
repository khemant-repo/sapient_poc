package companies.deloitte;

import java.util.Arrays;
import java.util.stream.Stream;

public class FindSecondSmallestElelement {
    public static void main(String[] args) {

        int[] arr = {5,2,8,3,1,1};

        findSecondSmallest(arr);
    }

    private static void findSecondSmallest(int[] arr) {

        int secondSmallest =
                Arrays.stream(arr)
                        .distinct()
                        .sorted()
                        .skip(1)
                        .findFirst().getAsInt();
        System.out.println("Second Smallest: "+secondSmallest);
    }
}
