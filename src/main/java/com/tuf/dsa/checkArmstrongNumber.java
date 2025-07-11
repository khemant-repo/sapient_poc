package com.tuf.dsa;

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
