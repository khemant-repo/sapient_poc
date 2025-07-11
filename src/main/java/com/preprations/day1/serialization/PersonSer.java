package com.preprations.day1.serialization;// File: Person.java (version 1 - sender side)
import java.io.Serializable;

public class PersonSer implements Serializable {
    // Manually setting serialVersionUID
    private static final long serialVersionUID = 1L;

    //updated for deser error senario
    //private static final long serialVersionUID = 2L;
    private String name;
    private int age;
    private String city; // New field added
    private String state; // New field added
    private String country; // New field added
    public PersonSer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonSer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
