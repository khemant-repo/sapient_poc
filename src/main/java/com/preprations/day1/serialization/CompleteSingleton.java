package com.preprations.day1.serialization;

import java.io.Serializable;

/**
 * Full Secured Singleton with Serialization + Reflection Protection
 */
public class CompleteSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final CompleteSingleton INSTANCE = new CompleteSingleton();
    private static boolean instanceCreated = false;

    private CompleteSingleton() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance() method to create Singleton");
        }
        instanceCreated = true;
    }

    public static CompleteSingleton getInstance() {
        return INSTANCE;
    }

    // For serialization safety
    private Object readResolve() {
        return INSTANCE;
    }
}
