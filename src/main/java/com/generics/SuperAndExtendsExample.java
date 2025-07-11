package com.generics;
import java.util.ArrayList;
import java.util.List;

class Animal {
    public void speak() {
        System.out.println("Animal speaking...");
    }
}

class Cat extends Animal {
    private String name;

    public void speak() {
        System.out.println("Meow!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void speak() {
        System.out.println("Woof!");
    }
}

class Gabru extends Dog {
    public void speak() {
        System.out.println("Gabru barks!");
    }
}

class Billo extends Cat {
    public void speak() {
        System.out.println("Billo meows!");
    }
}

public class SuperAndExtendsExample {
    public static void main(String[] args) {
        // Super: Can add Dog or subclass
        List<Animal> animalList = new ArrayList<>();
        superExample(animalList); // ✅ Works with Animal

        List<Dog> dogList = new ArrayList<>();
        superExample(dogList);    // ✅ Works with Dog

       /// superExample(new Gabru());
        List<Object> objectList = new ArrayList<>();
        superExample(objectList); // ✅ Works with Object

        // List<Gabru> gabruList = new ArrayList<>();
        // superExample(gabruList); // ❌ Compile error: Gabru is below Dog

        // Extends: Safe for read, not for add
        List<Dog> onlyDogs = new ArrayList<>();
        onlyDogs.add(new Dog());
        onlyDogs.add(new Gabru());
        extendsExample(onlyDogs); // ✅ Gabru is a subtype of Dog -> Animal

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Billo());
        extendsExample(catList); // ✅ Cat is subtype of Animal

        // Dry Run output will show which elements are read
    }

    // Lower Bounded Wildcard - ? super Dog
    private static void superExample(List<? super Dog> list) {
        list.add(new Dog());   // ✅ Allowed
        list.add(new Gabru()); // ✅ Allowed
        // list.add(new Animal()); // ❌ Not allowed, could break lower bound logic

        System.out.println("Reading elements (super):");
        for (Object obj : list) { // we only get Object when reading
            System.out.println("  -> " + obj.getClass().getSimpleName());
        }
    }

    // Upper Bounded Wildcard - ? extends Animal
    private static void extendsExample(List<? extends Animal> list) {
        System.out.println("Reading elements (extends):");
        for (Animal a : list) { // ✅ Safe to read
            a.speak();          // ✅ Dynamic dispatch works
        }

        // list.add(new Dog()); // ❌ Not allowed
        // list.add(new Animal()); // ❌ Not allowed
    }
}
