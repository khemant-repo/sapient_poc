package com.designPattern;

/*
1. private static instance with volatile keyword.
2. Make constructor private to prevent instantiation.
3. Use double-checked locking for thread-safe singleton.
*/

public class SingletonPattern {

    // Volatile ensures visibility and prevents instruction reordering issues
    private static volatile SingletonPattern INSTANCE;

    // Private constructor to prevent instantiation
    private SingletonPattern() {}

    // Public static method to get the single instance
    public static SingletonPattern getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonPattern.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonPattern();
                }
            }
        }
        return INSTANCE;
    }
}
