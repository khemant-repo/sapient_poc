package com.generics;

interface Moveable<T>{
    void move(T t);
}

class Feline implements Moveable<Cat> {

    @Override
    public void move(Cat cat) {
        System.out.println("Feline moved." + cat.getName());
    }
}

class Canine implements Moveable<Dog> {

    @Override
    public void move(Dog dog) {
        System.out.println("Canine moved." + dog.getName());
    }
}

class SomeMoveable<U> implements Moveable<U> {

    @Override
    public void move(U u) {
        System.out.println("some object moved." + u.toString());
    }
}
public class TestCustomGenericInterface {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.setName("mydog");
        new Canine().move(d1);

        Cat c1 = new Cat();
        c1.setName("myCat");
        new Feline().move(c1);

        // new Canine().move(c1); // not allowed
        // new Feline().move(d1); // not allowed

        new SomeMoveable<Cat>().move(c1);
        new SomeMoveable<Dog>().move(d1);

    }
}
