package com.tuf.dsa;

/**
 * An Armstrong number is a number that is equal to the sum of
 * its own digits each raised to the power of the number of digits.

 * Example:
 * 1. 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 ,
 * So, 153 is an armstrong number.

 * 2.9474 = 9^4 + 4^4 + 7^4 + 4^4 = 6561 + 256 + 2401 + 256 = 9474
 * so, 9474 is an armstrong number.
 */
public class checkArmstrongNumber {
    public static void main(String[] args) {
        int n = 9474;
        boolean isArmStrong = isArmstrongNumber(n);
        System.out.println("is "+ n +" is an armstrong number ? :"+ isArmStrong);

    }

    private static boolean isArmstrongNumber(int n) {

        int dup = n;
        int sum = 0;
        int numLen = String.valueOf(n).length();
        while(n>0){
            int lastDigit = n % 10;
            n = n/10;
            sum = sum + (int)Math.pow(lastDigit,numLen);
        }

        return sum == dup;
    }
}
