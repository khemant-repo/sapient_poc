package com.tuf.dsa;

/**
 * A palindrome number is a number that reads the same forward and backward.

 * Example Palindrome:
 * 121 → reverse is 121
 * 1331 → reverse is 1331
 * 12321 → reverse is 12321
 * 7 → reverse is 7

 Example not Palindrome:
   123 → reverse is 321
   4567 → reverse is 7654
 */
public class CheckPalindromNumber {
    public static void main(String[] args) {

        int n = 121;


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
