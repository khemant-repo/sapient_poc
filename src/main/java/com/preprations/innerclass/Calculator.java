package com.preprations.innerclass;

public class Calculator {
    public void calculate(int a, int b) {
        class Adder {
            int add() {
                return a + b;
            }
        }

        Adder adder = new Adder();
        System.out.println("Local Inner Class: Sum is " + adder.add());
    }
}
