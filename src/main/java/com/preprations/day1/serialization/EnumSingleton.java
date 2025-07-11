package com.preprations.day1.serialization;

public enum EnumSingleton {
    INSTANCE;

    public void show() {
        System.out.println("Enum Singleton: Only one instance always!");
    }
}
