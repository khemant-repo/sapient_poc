package com.preprations.innerclass;

public class Car {
    private String model = "Tesla";

    class Engine {
        void start() {
            System.out.println("Member Inner Class: Starting engine of " + model);
        }
    }
}
