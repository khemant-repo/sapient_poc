package com.internalScreenning;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "madam";
              boolean flag =   checkPalindrome(str);

        System.out.println("current string is palindrome: "+flag);
        char[] charArray = str.toCharArray();
        StringBuilder reversedString = new StringBuilder();
        System.out.println("checkPalindrome(str, charArray): "+checkPalindrome(str, charArray));
        System.out.println("*************************");
        boolean isPalindrome = withoutStringFunction(str);

        System.out.println("withoutStringFunction is current string is palindrome: "+isPalindrome);
    }

    private static boolean checkPalindrome(String str, char[] charArray) {
        str = str.toLowerCase();
        for (int i = 0; i< str.length()/2; i++){
            System.out.println("loop.."+i);
            char temp = charArray[i];
            charArray[i] = charArray[str.length()-i-1];
            charArray[str.length()-i-1] = temp;

        }
        System.out.println("charArray: "+String.valueOf(charArray));
        return String.valueOf(charArray).equals(str);
    }

    private static boolean withoutStringFunction(String str) {
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){
            sb.append(c);
        }
        return str.equals(sb.toString());
    }

    private static boolean checkPalindrome(String str) {
        StringBuilder reverseString = new StringBuilder(str);
        reverseString.reverse();
        return str.equals(reverseString.toString());
    }
}
