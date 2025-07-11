package com.tuf.dsa.java8;

public class FibonacciTraditional {

    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci terms
        printFibonacci(n);
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series (Traditional): ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
