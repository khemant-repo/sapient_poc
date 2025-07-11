package com.preprations.clone;

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }

    public Address deepCopy() {
        return new Address(this.city);
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep copy
    public Person deepClone() {
        return new Person(this.name, this.address.deepCopy());
    }
}

public class CloneDemo {
    public static void main(String[] args) throws Exception {
        Person original = new Person("John", new Address("NY"));
        Person shallowCopy = (Person) original.clone();
        Person deepCopy = original.deepClone();

        deepCopy.address.city = "LA";
        System.out.println("OriginalCopy: "+original.address.city); // LA
        System.out.println("ShallowCopy: "+shallowCopy.address.city); // LA
        System.out.println("DeepCopy: "+deepCopy.address.city);    // NY
    }
}
