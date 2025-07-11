package com.preprations.day1.serialization;

import java.io.Serializable;

public class BrokenSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final BrokenSingleton INSTANCE = new BrokenSingleton();

    private BrokenSingleton() {
        System.out.println("Constructor called");
    }

    public static BrokenSingleton getInstance() {
        return INSTANCE;
    }
}
