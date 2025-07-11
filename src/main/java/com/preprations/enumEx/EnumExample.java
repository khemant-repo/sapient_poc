package com.preprations.enumEx;

public class EnumExample {
    public static void main(String[] args) {
        PizzaSize size = PizzaSize.LARGE;
        System.out.println("Ordered size: " + size);
        System.out.println("Diameter: " + size.getDiameter() + " inches");
        for (PizzaSize pizzaSize: PizzaSize.values()){
            System.out.println("pizzaSize: "+pizzaSize);
        }
    }
}
