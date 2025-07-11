package com.revise.date02062025;

class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}
 
class Dog extends Animal {
    Dog() {
         
        System.out.println("Dog constructor called");
    }
}
 
public class Main {
    public static void main(String[] args) {
        new Dog();
    }
}
