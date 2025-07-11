package com.preprations.day1;

import java.util.Objects;

class Person {
    String name;
    Person(String name) { this.name = name; }

    /*@Override
    public boolean equals(Object o) {
        return o instanceof Person && ((Person) o).name.equals(this.name);
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
