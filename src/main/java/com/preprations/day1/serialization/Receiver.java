package com.preprations.day1.serialization;// File: Receiver.java
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Receiver {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PersonSer11.ser"));

        PersonSer p = (PersonSer) ois.readObject(); // 💥 Exception here!
        ois.close();

        System.out.println("Person: " + p);
    }
}
