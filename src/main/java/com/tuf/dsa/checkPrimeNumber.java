package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

/**
 * A prime number is a natural number greater than 1 that has exactly two distinct positive divisors:
 * 1 and itself.
 *
 * ✅ Examples of Prime Numbers:
         * 2 (only divisible by 1 and 2)
         * 3 (only divisible by 1 and 3)
         * 5, 7, 11, 13, 17, 19, 23, 29, 31, ...
         * ✅ Note: 2 is the only even prime number — all other even numbers are divisible by 2.

 * ❌ Non-Prime (Composite) Examples:
         * 1 → has only one divisor (not prime)
         * 4 → divisible by 1, 2, 4
         * 6 → divisible by 1, 2, 3, 6
         * 9 → divisible by 1, 3, 9
 */
public class checkPrimeNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        for(int i=0; i< list.size(); i++){
          //  boolean isPrime = isPrime(list.get(i));
            boolean isPrime = isPrimeOptimized(list.get(i));
            if(isPrime){
                System.out.println(list.get(i) + " is a prime number");
            }else{
                System.out.println(list.get(i) + " is not a prime number");
            }
        }
    }

    private static boolean isPrimeOptimized(int n) {
        int count = 0;
        for(int i=1 ; i*i <= n;i++){

            if(n%i==0) {
                count++;
                if(n/i !=i){
                    count++;
                }
            }

        }
        return count==2;
    }

    private static boolean isPrime(int n) {
        int count = 0;
        for(int i =1 ; i<= n; i++){
            if(n%i==0) count++;
        }
        return count==2;
    }
}
