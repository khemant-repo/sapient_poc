package companies.deloitte;

import java.util.Arrays;
import java.util.List;

public class SumEvenOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        caluculateSum(numbers);
    }

    private static void caluculateSum(List<Integer> numbers) {
        int evenSum = 0;
        int oddSum = 0;
        for(int i=0; i< numbers.size();i++){
            if(numbers.get(i)%2==0)
                evenSum +=numbers.get(i);
            else
                oddSum += numbers.get(i);
        }
        System.out.println("Sum of even numbers : "+evenSum);
        System.out.println("Sum of Odd numbers : "+oddSum);
    }
}
