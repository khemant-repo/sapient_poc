package com.tuf.dsa;

public class ReverseNumbers {
    public static void main(String[] args) {
        int n = 7789;

        System.out.println("reversed numbers are: "+ reverse(n));
    }

    private static int reverse(int n) {

        int reverseNum = 0;
        while(n>0){
            int lastDigit = n % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            n = n/10;
        }

        return reverseNum;
    }
}
