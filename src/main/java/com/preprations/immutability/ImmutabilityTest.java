package com.preprations.immutability;

final class Employee {
    private final String name;
    private final int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }
}

public class ImmutabilityTest {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 100);
        // emp.name = "Bob"; // Not allowed
        System.out.println(emp.getName()); // Alice
    }
}
