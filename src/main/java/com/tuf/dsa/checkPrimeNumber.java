package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

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
