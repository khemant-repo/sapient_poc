package com.preprations.day1.serialization;

import java.io.*;

public class SingletonTest {

    public static void main(String[] args) throws Exception {
        testBrokenSingleton();
        testFixedSingleton();
        testEnumSingleton();
    }

    private static void testBrokenSingleton() throws Exception {
        System.out.println("🔴 Testing BrokenSingleton:");

        BrokenSingleton s1 = BrokenSingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("broken.obj"));
        oos.writeObject(s1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("broken.obj"));
        BrokenSingleton s2 = (BrokenSingleton) ois.readObject();
        ois.close();

        System.out.println("Same instance? " + (s1 == s2));  // false
        System.out.println("-----------------------------------");
    }

    private static void testFixedSingleton() throws Exception {
        System.out.println("🟢 Testing FixedSingleton:");

        FixedSingleton s1 = FixedSingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fixed.obj"));
        oos.writeObject(s1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fixed.obj"));
        FixedSingleton s2 = (FixedSingleton) ois.readObject();
        ois.close();

        System.out.println("Same instance? " + (s1 == s2));  // true
        System.out.println("-----------------------------------");
    }

    private static void testEnumSingleton() throws Exception {
        System.out.println("✅ Testing EnumSingleton:");

        EnumSingleton s1 = EnumSingleton.INSTANCE;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enum.obj"));
        oos.writeObject(s1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enum.obj"));
        EnumSingleton s2 = (EnumSingleton) ois.readObject();
        ois.close();

        System.out.println("Same instance? " + (s1 == s2));  // true
        s1.show();
        System.out.println("-----------------------------------");
    }
}
