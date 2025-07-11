package com.preprations.day1.serialization;// File: Sender.java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Sender {
    public static void main(String[] args) throws Exception {
        PersonSer p = new PersonSer("Hemant", 30);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PersonSer11.ser"));
        oos.writeObject(p);
        oos.close();

        System.out.println("✅ Object serialized as PersonSer.ser");
    }
}
