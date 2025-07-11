package com.preprations.innerclass;

public class OuterClass {
    static String company = "OpenAI";

    static class StaticNestedClass {
        void display() {
            System.out.println("Static Nested Class: Company is " + company);
        }
    }
}
