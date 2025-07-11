package com.tuf.dsa;

public class CountDigits {
    public static void main(String[] args) {
        int numbers = 7789;
        System.out.println("Digit count is :"+count(numbers));
    }

    private static int count(int numbers) {

        int count =0;
        while(numbers > 0){
            numbers = numbers/10;
            count++;
        }
        return count;
    }
}
