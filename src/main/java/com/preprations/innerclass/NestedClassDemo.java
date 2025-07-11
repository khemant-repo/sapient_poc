package com.preprations.innerclass;

public class NestedClassDemo {
    public static void main(String[] args) {
        // Static Nested Class
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.display();

        // Member Inner Class
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        engine.start();

        // Local Inner Class
        Calculator calc = new Calculator();
        calc.calculate(5, 10);


    }
}
