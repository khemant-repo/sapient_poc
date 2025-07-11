package com.preprations.day1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class MainApplication {

    public static void main(String[] args) {
      //  test_equalsAndHashcode();
        //test_onlyHashcode();
      //  test_hashset();
        // test_hashmap();
        test_serialization_with_singlton();
    }

    private static void test_serialization_with_singlton() {


        ObjectInputStream in = null;
        try {
            Singleton s1 = Singleton.getInstance();
            Singleton s2 = null;
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
            out.writeObject(s1);
            in = new ObjectInputStream(new FileInputStream("singleton.obj"));
            s2 = (Singleton) in.readObject();
            System.out.println(s1 == s2);  // ❌ false – breaks singleton!
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }





    }

    /**
     * if you put an object in HashSet and later change a field used in equals() or hashCode()?
     */
    private static void test_hashmap() {
        HashSet<Person> set = new HashSet<>();
        Person p = new Person("Alice");

        set.add(p);
        System.out.println("Contains before mutation: " + set.contains(p)); // true
        System.out.println("before hashcode:" +p.hashCode());
        // Mutate the field used in hashCode and equals
        p.name = "Bob";
        System.out.println("After hashcode:" +p.hashCode());
        System.out.println("Contains after mutation: " + set.contains(p)); // false ❌
        System.out.println("Set contents: " + set); // still contains the mutated object
        set.remove(p); // won't work ❌

        // Why? Because hashCode is now different, points to wrong bucket.
    }

    /**
     * Why is this dangerous?
     * Hash-based collections (HashMap, HashSet, Hashtable) depend on both:
     *
     * hashCode() to find the bucket.
     *
     * equals() to confirm identity.
     *
     * If only hashCode() is overridden:
     *
     * Objects land in the correct bucket.
     *
     * But equals() fails to confirm they’re the same → allows duplicates.
     */
    private static void test_hashset() {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("Hemant");
        Person p2 = new Person("Hemant");
        set.add(p1);
        set.add(p2);  // You might expect this to be ignored (duplicate), but it gets added!
        System.out.println(set.size()); // ❗️ 2 — NOT GOOD

    }

    private static void test_onlyHashcode() {
        Person p1 = new Person("Hemant");
        Person p2 = new Person("Hemant");

        //commment equals method and try
        System.out.println(p1.equals(p2)); // ❌ false, because equals() not overridden
        System.out.println(p1.hashCode() == p2.hashCode()); // ✅ true, same hashCode
    }

    private static void test_equalsAndHashcode() {
        Person p1 = new Person("Hemant");
        Person p2 = new Person("Hemant");

        //must override equals
        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.hashCode() == p2.hashCode()); // ✅ true, same hashCode

    }
}