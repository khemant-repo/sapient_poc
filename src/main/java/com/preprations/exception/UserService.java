package com.preprations.exception;

public class UserService {
    public void register(String name, int age) {
        if (age < 18) {
            throw new InvalidAgeException("User must be 18 or older to register.");
        }
        System.out.println("User " + name + " registered successfully!");
    }
}
