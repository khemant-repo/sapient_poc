package com.tuf.dsa;

public class CheckPalindromNumber {
    public static void main(String[] args) {

        int n = 1219;


       if(isPlindrome(n)){
           System.out.println("given number :"+ n + " is palindrome");
       }else {
           System.out.println("given number :"+ n + " is not palindrome");
       }

    }

    private static boolean isPlindrome(int n) {
        int dup = n;
        int reverseN = 0;
        while(n>0){
            int lastDigit = n %10;
            n = n/10;
            reverseN = reverseN * 10+ lastDigit;
        }

        return reverseN == dup;
    }
}
