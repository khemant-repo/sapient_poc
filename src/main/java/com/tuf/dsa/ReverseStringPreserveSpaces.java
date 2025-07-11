package com.tuf.dsa;

public class ReverseStringPreserveSpaces {

    public static void main(String[] args) {
        String str = "My name is hemant";

        // Step 1: Convert string to character array
        char[] input = str.toCharArray();
        char[] result = new char[input.length];

        // Step 2: Mark spaces in the result array
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                result[i] = ' ';
            }
        }

        // Step 3: Fill characters in reverse order, skipping spaces
        int j = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != ' ') {
                // Find next non-space character from the end
                while (j >= 0 && input[j] == ' ') {
                    j--;
                }
                result[i] = input[j];
                j--;
            }
        }

        // Step 4: Print result
        System.out.println("Original : " + str);
        System.out.println("Reversed : " + new String(result));
    }
}
