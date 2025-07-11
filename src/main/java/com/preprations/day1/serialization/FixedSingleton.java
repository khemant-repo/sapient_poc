package com.preprations.day1.serialization;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class FixedSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final FixedSingleton INSTANCE = new FixedSingleton();

    private FixedSingleton() {
        System.out.println("Constructor called");
    }

    public static FixedSingleton getInstance() {
        return INSTANCE;
    }

    // readResolve fixes the singleton breakage
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
